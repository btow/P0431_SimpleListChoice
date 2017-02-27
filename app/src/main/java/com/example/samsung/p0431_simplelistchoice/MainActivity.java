package com.example.samsung.p0431_simplelistchoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String LOG_TAG = "myLogs";

    ListView lvMain;
    String[] names;
    Button btnChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        lvMain = (ListView) findViewById(R.id.lvMain);
        //устанавливаем режим выбора пунктов списка
        lvMain.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //создаём адаптер, используя массив из файла ресурсов
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.names, android.R.layout.simple_list_item_single_choice);
        //подключаем адаптер к списку
        lvMain.setAdapter(adapter);

        btnChecked = (Button) findViewById(R/ R.id.btnChecked);
        btnChecked.setOnClickListener(this);

        //получаем массив из файла ресурсов
        names = getResources().getStringArray(R.array.names);
    }

    @Override
    public void onClick(View v) {
        //пишев лог выделенный элемент
        Log.d(LOG_TAG, "Checked: " + names[lvMain.getCheckedItemPosition()]);
    }
}
