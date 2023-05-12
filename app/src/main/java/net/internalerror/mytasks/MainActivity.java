package net.internalerror.mytasks;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.internalerror.mytasks.adapter.TaskAdapter;
import net.internalerror.mytasks.data.Task;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTaskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewTaskList = findViewById(R.id.activity_main_recycler_view_task_list);

        TaskAdapter adapter = new TaskAdapter(List.of(new Task("Test", new Date())));

        recyclerViewTaskList.setAdapter(adapter);
        recyclerViewTaskList.setLayoutManager(new LinearLayoutManager(this));
    }
}