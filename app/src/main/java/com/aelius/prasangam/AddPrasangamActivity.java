package com.aelius.prasangam;

import android.content.DialogInterface;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aelius.prasangam.adapter.FileListAdapter;
import com.jaiselrahman.filepicker.activity.FilePickerActivity;
import com.jaiselrahman.filepicker.config.Configurations;
import com.jaiselrahman.filepicker.model.MediaFile;

import java.util.ArrayList;
import java.util.Locale;

public class AddPrasangamActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llImageView, llTextView;
    private ImageView imgImage;
    private RelativeLayout rlSpeechView;
    private TextView tvSelectText;
    private TextView tvSelectImage;
    private TextView tvSelectDocs;
    private TextView tvSelectAudio;
    private TextView tvSelectVideo;
    private TextView tvSelectSpeech;
    private TextView tvSelectSend, tvLanguageSelect;
    private EditText txvResult;
    private final static int FILE_REQUEST_CODE = 1;
    private final static int SPEECH_REQUEST_CODE = 2;
    //lang code 1= english 2= gujrati
    int langCode = 1;


    private FileListAdapter fileListAdapter;
    private ArrayList<MediaFile> mediaFiles = new ArrayList<>();
    EditText edtTextMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prasangam);
        initId();

    }

    void initId() {
        llTextView = (LinearLayout) findViewById(R.id.llTextView);
        llImageView = (LinearLayout) findViewById(R.id.llImageView);
        rlSpeechView = findViewById(R.id.rlSpeechView);
        imgImage = (ImageView) findViewById(R.id.imgImage);
        tvSelectText = (TextView) findViewById(R.id.tvSelectText);
        tvSelectImage = (TextView) findViewById(R.id.tvSelectImage);
        tvSelectDocs = (TextView) findViewById(R.id.tvSelectDocs);
        tvSelectAudio = (TextView) findViewById(R.id.tvSelectAudio);
        tvSelectVideo = (TextView) findViewById(R.id.tvSelectVideo);
        tvSelectSpeech = (TextView) findViewById(R.id.tvSelectSpeech);
        tvSelectSend = (TextView) findViewById(R.id.tvSelectSend);
        edtTextMsg = (EditText) findViewById(R.id.edtText);
        txvResult = (EditText) findViewById(R.id.txvResult);
        tvLanguageSelect = findViewById(R.id.tvLanguageSelect);
        tvLanguageSelect.setOnClickListener(this);

        RecyclerView recyclerView = findViewById(R.id.file_list);
        fileListAdapter = new FileListAdapter(mediaFiles);
        recyclerView.setAdapter(fileListAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        tvSelectText.setOnClickListener(this);
        tvSelectImage.setOnClickListener(this);
        tvSelectDocs.setOnClickListener(this);
        tvSelectAudio.setOnClickListener(this);
        tvSelectVideo.setOnClickListener(this);
        tvSelectSpeech.setOnClickListener(this);
        tvSelectSend.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        mediaFiles.clear();

        switch (v.getId()) {

            case R.id.tvSelectText:
                setTextLayout();
                break;
            case R.id.tvSelectImage:
                setImageLayout();
                Intent intent = new Intent(AddPrasangamActivity.this, FilePickerActivity.class);
                intent.putExtra(FilePickerActivity.CONFIGS, new Configurations.Builder()
                        .setCheckPermission(true)
                        .setSelectedMediaFiles(mediaFiles)
                        .enableImageCapture(true)
                        .setShowVideos(false)
                        .setSkipZeroSizeFiles(true)
                        .setMaxSelection(5)
                        .build());
                startActivityForResult(intent, FILE_REQUEST_CODE);
                break;
            case R.id.tvSelectDocs:
/* setImageLayout();
Intent intentDoc = new Intent(AddPrasangamActivity.this, FilePickerActivity.class);
intentDoc.putExtra(FilePickerActivity.CONFIGS, new Configurations.Builder()
.setCheckPermission(true)
.setSelectedMediaFiles(mediaFiles)
.setShowFiles(true)
.setShowImages(false)
.setShowVideos(false)
.setMaxSelection(5)
.build());
startActivityForResult(intentDoc, FILE_REQUEST_CODE);*/
                break;
            case R.id.tvSelectAudio:
/* Intent intentAudio = new Intent(AddPrasangamActivity.this, FilePickerActivity.class);
intentAudio.putExtra(FilePickerActivity.CONFIGS, new Configurations.Builder()
.setCheckPermission(true)
.setSelectedMediaFiles(mediaFiles)
.setShowImages(false)
.setShowVideos(false)
.setShowAudios(true)
.setMaxSelection(5)
.build());
startActivityForResult(intentAudio, FILE_REQUEST_CODE);*/
                break;
            case R.id.tvSelectVideo:
/* Intent intentVideo = new Intent(AddPrasangamActivity.this, FilePickerActivity.class);
intentVideo.putExtra(FilePickerActivity.CONFIGS, new Configurations.Builder()
.setCheckPermission(true)
.setSelectedMediaFiles(mediaFiles)
.enableVideoCapture(true)
.setShowImages(false)
.setMaxSelection(5)
.build());
startActivityForResult(intentVideo, FILE_REQUEST_CODE);*/
                break;
            case R.id.tvSelectSpeech:
                setSpeechLayout();
//selectLanguage();
                break;
            case R.id.tvSelectSend:
                sendMsgToServer();
                break;
            case R.id.tvLanguageSelect:
                selectLanguage();
                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_REQUEST_CODE
                && resultCode == RESULT_OK
                && data != null) {
            mediaFiles.clear();
            mediaFiles.addAll(data.<MediaFile>getParcelableArrayListExtra(FilePickerActivity.MEDIA_FILES));
            fileListAdapter.notifyDataSetChanged();
        } else if (requestCode == SPEECH_REQUEST_CODE) {
            if (resultCode == RESULT_OK && data != null) {
                Log.i("AddActivity", "**** sppeech to text ");
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                txvResult.setText(result.get(0));
                txvResult.requestFocus();
                txvResult.setSelection(txvResult.length());
            }
        }

    }

    void setImageLayout() {
        llImageView.setVisibility(View.VISIBLE);

        if (llTextView.getVisibility() == View.VISIBLE) {
            llTextView.setVisibility(View.GONE);
        }
        if (rlSpeechView.getVisibility() == View.VISIBLE) {
            rlSpeechView.setVisibility(View.GONE);
        }
    }

    void setTextLayout() {
        llTextView.setVisibility(View.VISIBLE);
        edtTextMsg.requestFocus();
        if (llImageView.getVisibility() == View.VISIBLE) {
            llImageView.setVisibility(View.GONE);
        }
        if (rlSpeechView.getVisibility() == View.VISIBLE) {
            rlSpeechView.setVisibility(View.GONE);
        }


    }

    void setSpeechLayout() {
        rlSpeechView.setVisibility(View.VISIBLE);
        if (llImageView.getVisibility() == View.VISIBLE) {
            llImageView.setVisibility(View.GONE);
        }
        if (llTextView.getVisibility() == View.VISIBLE) {
            llTextView.setVisibility(View.GONE);
        }
    }

    private void sendMsgToServer() {

    }

    public void getSpeechInput(View view) {
        String localCode = "";
        if (langCode == 1) {
            localCode = "en-IN";
        } else if (langCode == 2) {
            localCode = "gu-IN";
        }

        Log.i("AddActivity", "**** language default " + Locale.getDefault());
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, localCode);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    void selectLanguage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.language);
// Add the buttons
        builder.setPositiveButton(R.string.language_en, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                langCode = 1;
                tvLanguageSelect.setText("Selected Language : English ");
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(R.string.language_gujrati, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
// User cancelled the dialog
                langCode = 2;
                tvLanguageSelect.setText("Selected Language : Gujrati ");
                dialog.dismiss();

            }
        });

        builder.create().show();
    }

}