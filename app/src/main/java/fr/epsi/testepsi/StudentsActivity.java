package fr.epsi.testepsi;

import android.content.Intent;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StudentsActivity extends EpsiActivity {

    ArrayList<Student> students;
    public static void displayActivity(EpsiActivity activity){
        Intent intent = new Intent(activity,StudentsActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        setTitle("Students");
        showBack();
        students = new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(Data.allData);
            JSONArray jsonItems=jsonObject.getJSONArray("items");
            for (int i=0;i<jsonItems.length();i++){
                Student student=new Student(jsonItems.getJSONObject(i));
                students.add(student);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}