package net.internalerror.mytasks.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.internalerror.mytasks.R;
import net.internalerror.mytasks.data.Task;

import java.text.SimpleDateFormat;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageButton imageButtonCompleteTask;
        private final TextView textViewTaskName;
        private final TextView textViewTaskDeadline;
        private final ImageView imageViewTaskStatus;
        private final ImageButton imageButtonEditTask;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageButtonCompleteTask = itemView.findViewById(R.id.fragment_task_image_button_complete_task);
            textViewTaskName = itemView.findViewById(R.id.fragment_task_text_view_task_name);
            textViewTaskDeadline = itemView.findViewById(R.id.fragment_task_text_view_task_deadline);
            imageViewTaskStatus = itemView.findViewById(R.id.fragment_task_image_view_task_status);
            imageButtonEditTask = imageButtonCompleteTask.findViewById(R.id.fragment_task_image_button_edit_task);

        }

        public void populate(Task task) {

            textViewTaskName.setText(task.getName());
            textViewTaskDeadline.setText(SimpleDateFormat.getDateInstance().format(task.getDeadline()));

        }
    }

    private final List<Task> list;

    public TaskAdapter(List<Task> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View taskView = inflater.inflate(R.layout.fragment_task, parent, false);

        return new ViewHolder(taskView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        holder.populate(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
