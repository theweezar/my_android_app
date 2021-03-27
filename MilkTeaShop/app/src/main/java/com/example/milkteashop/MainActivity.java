package com.example.milkteashop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setSortMenu();
        testFromAnotherClassDialog();
    }

    public void testFromAnotherClassDialog(){
        SortMenuDialog sortMenu = new SortMenuDialog();
        TextView sortBtn = findViewById(R.id.sort_btn);
        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                sortMenu.show(fm, null);
            }
        });
    }

    // Set dialog vào nút "Sort by"
    public void setSortMenu(){
        Dialog sortMenu = getSortMenuDialog();
        TextView sortBtn = findViewById(R.id.sort_btn);
        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vì cái dialog này được tạo bên trong class nên chỉ cần show() là sẽ hiện ra
                // còn nếu ta tạo 1 class extends Dialog khác thì phải có getSupportFragmentManager() để hỗ trợ
                sortMenu.show();
            }
        });
    }

    // Set các view và sự kiện bên trong dialog và return cái dialog đó về
    public Dialog getSortMenuDialog(){
        // alertDialog.builder là object xây dựng cái nội dung của cái popup dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // setView là set layout của 1 layout khác, nhưng bắt buộc phải để nó nằm trong layout mà ta cho nó
        // hiện trên màn hình, ko thể tách ra 1 class khác để extends xuống
        builder.setTitle("Sort by")
                .setView(getLayoutInflater().inflate(R.layout.sort_radio_button_group, null))
                .setPositiveButton("Set", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }

    public void onRadioButtonClicked(View view) {
//        RadioGroup sortModeGroup = view.findViewById(R.id.sort_mode_group);
//        RadioGroup sortOrderGroup = view.findViewById(R.id.sort_order_group);

//        Toast.makeText(MainActivity.this,"Choose sort mode")
    }
}