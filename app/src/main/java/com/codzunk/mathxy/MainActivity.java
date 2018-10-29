package com.codzunk.mathxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private EditText editExpression;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editExpression = findViewById(R.id.edit_expression);
        resultView = findViewById(R.id.result_board);

        Button evaluate = findViewById(R.id.btn_evaluate);
        evaluate.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String expression = editExpression.getText().toString();
            if (!expression.isEmpty()){
                Expression e = new Expression(expression);
                resultView.setText(String.format("%s", e.calculate()));
            }
        }
    };
}
