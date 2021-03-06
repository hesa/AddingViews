package se.juneday.throwaway.addingviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout  = (LinearLayout) findViewById(R.id.top_layout);
        Button b  = new Button(this);
        b.setText("Butoni");
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Button) view).setText("Butoni clicked (" + getResources().getInteger(R.integer.nr_buttons) + ")");
            }
        });
        Button okButton  = new Button(this);
        okButton.setText("Ok");
        okButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                b.setText("Ok as well");
            }
        });

        layout.addView(b);
        layout.addView(okButton);

        LinearLayout buttonLayout = new LinearLayout(this);
        TextView tv = new TextView(this);
        tv.setText(R.string.info_text);
        layout.addView(buttonLayout);
    }

    // Letting the class implement OnClickListener
    // ... no, don't do that

    // Using inner class
    // .... well, don't do this either.
    /*
        In the onCreate method:
        b.setOnClickListener(new ButtonListener());

        In the class scope:
    class ButtonListener implements OnClickListener {

        @Override
        public void onClick(View view) {
           ((Button) view).setText("Butoni clicked");
        }
    }
    */

    // Using anonymous inner class
    /*
        In the onCreate method:
        b.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            ((Button) view).setText("Butoni clicked");
        }
    });
    */

    // Using lambda
    /*            b.setOnClickListener((view)-> ((Button) view).setText("Butoni clicked using lambada"));
    */

}
