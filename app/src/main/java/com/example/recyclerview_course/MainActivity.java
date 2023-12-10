package com.example.recyclerview_course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CourseAdapter adapter;
    private List<Course> courseList;
    Button btnAddCourse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseList = new ArrayList<>();

        courseList.add(new Course("CMP354", "Lập Trình Di Động", "Trịnh Đồng Thạch Trúc", R.mipmap.ic_launcher));
        courseList.add(new Course("CMP324", "Lập Trình Java", "Nguyễn Thanh Tùng", R.drawable.java));
        courseList.add(new Course("CMP332", "Lập Trình Windows", "Nguyễn Huy Cường", R.drawable.win));

        adapter = new CourseAdapter(this, courseList);
        recyclerView.setAdapter(adapter);

        btnAddCourse = findViewById(R.id.btnAddCourse);
        btnAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //openAddCourseDialog();

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_course);

                EditText edtCourseCode = dialog.findViewById(R.id.edtCourseCode);
                EditText edtCourseName = dialog.findViewById(R.id.edtCourseName);
                EditText edtLecturerName = dialog.findViewById(R.id.edtLecturerName);

                Button btnAdd = dialog.findViewById(R.id.btnAdd);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String courseCode = "", courseName = "", lecturerName = "";

                        if (!edtCourseCode.getText().toString().equals("")) {
                            courseCode = edtCourseCode.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter course code!", Toast.LENGTH_SHORT).show();
                        }

                        if (!edtCourseName.getText().toString().equals("")) {
                            courseName = edtCourseName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter course name!", Toast.LENGTH_SHORT).show();
                        }

                        if (!edtLecturerName.getText().toString().equals("")) {
                            lecturerName = edtLecturerName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter lecturer name!", Toast.LENGTH_SHORT).show();
                        }


                        courseList.add(new Course(courseCode, courseName, lecturerName, R.drawable.c));
                        adapter.notifyItemChanged(courseList.size() - 1);
                        recyclerView.scrollToPosition(courseList.size() - 1);

                        // Đóng Dialog sau khi thêm xong
//                dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}
