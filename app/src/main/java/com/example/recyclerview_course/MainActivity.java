package com.example.recyclerview_course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        courseList.add(new Course("CMP354", "Lập Trình Di Động", "Trịnh Đồng Thạch Trúc", R.mipmap.ic_launcher ));
        courseList.add(new Course("CMP324", "Lập Trình Java", "Nguyễn Thanh Tùng", R.drawable.java));
        courseList.add(new Course("CMP332", "Lập Trình Windows", "Nguyễn Huy Cường", R.drawable.win));

        adapter = new CourseAdapter(this,courseList);
        recyclerView.setAdapter(adapter);

        btnAddCourse = findViewById(R.id.btnAddCourse);
        btnAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thêm một khóa học mới vào danh sách
                courseList.add(new Course("New Course", "NEW123", "New Course", R.drawable.java));

                // Thông báo cho Adapter biết rằng dữ liệu đã thay đổi
                adapter.notifyDataSetChanged();
            }
        });
    }

}