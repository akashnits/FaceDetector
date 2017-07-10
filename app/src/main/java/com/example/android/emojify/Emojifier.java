package com.example.android.emojify;


import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    public static final String TAG= Emojifier.class.getSimpleName();

    public Emojifier() {
    }

    public static void detectFaces(Context context, Bitmap bitmap){
        com.google.android.gms.vision.face.FaceDetector faceDetector= new com.google.android.gms.vision.face.FaceDetector
                .Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        Frame frame= new Frame.Builder().setBitmap(bitmap).build();

        SparseArray<Face> faces= faceDetector.detect(frame);
        if(faces != null && faces.size() >0)
            Log.v(TAG, String.valueOf(faces.size()));

        faceDetector.release();
    }
}
