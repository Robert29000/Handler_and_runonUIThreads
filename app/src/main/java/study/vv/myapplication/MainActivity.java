package study.vv.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView res;
    MyHandler handler=new MyHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res=(TextView)findViewById(R.id.result);
        new MyThread().start();
    }
    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            res.setText(msg.arg1+"");
        }
    }
    class MyThread extends Thread{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                /*Message m=new Message();
                m.arg1=i;
                handler.sendMessage(m);*/
                final int k=i;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        res.setText(k+"");
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


