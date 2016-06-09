package kr.hs.emirim.sinyh104.simpledialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    String[] items=new String[]{"젤리빈","킷켓","롤리팝"};
    boolean[] checkArr= {false, true, false};
    Button but_dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but_dialog=(Button)findViewById(R.id.but_dialog);
        but_dialog.setOnClickListener(this);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("first Dialog");

        /*dialog.setItems(items,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                but.setText(items[which]);
            }
        });

        dialog.setIcon(R.drawable.sign);*/
       /* dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                but_dialog.setText(items[which]);
            }
        });*/

        dialog.setMultiChoiceItems(items, checkArr,new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog,int which, boolean isChecked) {
                but_dialog.setText(items[which]);
            }
        });

        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "대화상자의 확인 버튼을 클릭했음.",Toast.LENGTH_LONG).show();
            }
        });

        dialog.show();
    }
}
