package com.example.gestiondestock.vue;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.gestiondestock.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.util.UUID;


public class AddArticleActivity extends AppCompatActivity {
    SQLiteDatabase db;
    private Button buttonChoose;
    private Button buttonUpload;
    private ImageButton btnRetourAddArt;
    //init firebaseStorage
    private FirebaseStorage storage;
    //init storage reference
    private StorageReference storageReference;

    private EditText editText;

    //Image request code
    //private int PICK_IMAGE_REQUEST = 1;

    //storage permission code
    //private static final int STORAGE_PERMISSION_CODE = 123;

    //Bitmap to get image from gallery
    //private Bitmap bitmap;

    //Uri to store the image uri
    private Uri imageUri;


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_article);
        ecouteRetourMenu1();

        //requestStoragePermission();

        //Initializing views
        buttonChoose = (Button) findViewById(R.id.buttonChoose);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        btnRetourAddArt = (ImageButton) findViewById(R.id.btnRetourAddArt);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        try {
            db = openOrCreateDatabase("gestion_app", SQLiteDatabase.CREATE_IF_NECESSARY, null);

            add();
        } catch (SQLException e)
        {
        }
        buttonChoose.setOnClickListener(new View.OnClickListener(){
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                choosePicture();
            }
        });
        //Setting clicklistener
        //select();
        //upload();

    }

    private void choosePicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }

    /**
     * retour au menu
     */
    private void ecouteRetourMenu1(){
        ((ImageButton)findViewById(R.id.btnRetourAddArt)).setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AddArticleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data!=null && data.getData()!=null){
            imageUri = data.getData();
            //imageView.setImageURI(imageUri);

        }
    }

    private void uploadPicture() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Uploading image");
        pd.show();
        //final String randomKey = UUID.randomUUID().toString();
        StorageReference riversRef = storageReference.child(imageUri.getPath());
        riversRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        pd.dismiss();
                        Snackbar.make(findViewById(android.R.id.content),"image Uploaded.",Snackbar.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        pd.dismiss();
                        Toast.makeText(getApplicationContext(),"Failed To Upload",Toast.LENGTH_LONG).show();
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double progressPercent = (100.00*taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                pd.setMessage("percentage: " + (int) progressPercent +"%");
            }
        });
    }

    /*
     * This is the method responsible for image upload
     * We need the full image path and the name for the image in this method
     * */
/*
    public void uploadMultipart() {

        //getting the actual path of the image
        String path = getPath(filePath);

        //Uploading code
        try {
            String uploadId = UUID.randomUUID().toString();

            //Creating a multi part request
            new MultipartUploadRequest(this, uploadId, Constants.UPLOAD_URL)
                    .addFileToUpload(path, "image") //Adding file
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(2)
                    .startUpload(); //Starting the upload

        } catch (Exception exc) {
            Toast.makeText(this, exc.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    //method to show file chooser
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    //handling the image chooser activity result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //method to get the file path from uri
    public String getPath(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }


    //Requesting permission
    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }


    //This method will be called when the user will tap on allow or deny
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }


    public void select() {
        ((Button) findViewById(R.id.buttonChoose)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });
    }

   public void upload() {
        ((Button) findViewById(R.id.buttonUpload)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
//                uploadMultipart();
                add();
            }
        });
    }
*/
    public void add(){
        EditText lib = (EditText) findViewById(R.id.lib);
        EditText qte = (EditText) findViewById(R.id.quantité);
        //ImageView image = (ImageView) findViewById(R.id.imageView);
        EditText stockmin = (EditText) findViewById(R.id.stockMin);
        EditText stockmax = (EditText) findViewById(R.id.stockMax);
        EditText prix = (EditText) findViewById(R.id.prix);
        EditText description = (EditText) findViewById(R.id.description);



        ((Button) findViewById(R.id.buttonUpload)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                ContentValues values = new ContentValues();

                if(lib.getText().toString() != "") {
                    values.put("libArticle", lib.getText().toString());
                    values.put("qteArticle", qte.getText().toString());
                    values.put("description", description.getText().toString());
                    values.put("image", imageUri.getPath());
                    values.put("stockMin", stockmin.getText().toString());
                    values.put("stockMax", stockmax.getText().toString());
                    values.put("prix", prix.getText().toString());
                    if((db.insert("article", null, values))!=-1)
                    {
                        Toast.makeText(AddArticleActivity.this, "Record Successfully Inserted", Toast.LENGTH_SHORT).show();
                        uploadPicture();
                        Intent intent = new Intent(AddArticleActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(AddArticleActivity.this, "Insert Error", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(AddArticleActivity.this, "Insert Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}