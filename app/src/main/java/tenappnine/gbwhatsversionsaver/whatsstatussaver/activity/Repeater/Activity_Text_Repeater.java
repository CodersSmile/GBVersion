package tenappnine.gbwhatsversionsaver.whatsstatussaver.activity.Repeater;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.io.IOUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;
import tenappnine.gbwhatsversionsaver.whatsstatussaver.activity.R;

@SuppressLint("WrongConstant")
public class Activity_Text_Repeater extends AppCompatActivity {
    private Calendar calendar = Calendar.getInstance();
    public SharedPreferences data;
    public boolean first_repeat = false;
    private double history_index = 0.0d;
    public EditText how_many_input;
    ImageView ic_whats_share;
    public Intent intent = new Intent();
    ImageView iv_copy_text;
    ImageView iv_delete_text;
    public CheckBox line_checkbox;
    public double line_number = 0.0d;
    public CheckBox line_number_checkbox;
    private LinearLayout ln_repeat;
    public double repeat = 0.0d;
    public EditText repeat_input;
    public TextView repeated_output;
    public CheckBox space_checkbox;
    public String text_repeat = "";
    public String text_to_repeat = "";
    private Vibrator vibrator;
    LinearLayout vscroll1;
    private int Start_Type_Index;

    private GifImageView acion_qureka1;
    private GifImageView acion_qureka2;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_text_repeater);


        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.ln_repeat = (LinearLayout) findViewById(R.id.ln_repeat);
        this.repeat_input = (EditText) findViewById(R.id.repeat_input);
        this.how_many_input = (EditText) findViewById(R.id.how_many_input);
        this.space_checkbox = (CheckBox) findViewById(R.id.space_checkbox);
        this.line_checkbox = (CheckBox) findViewById(R.id.line_checkbox);
        this.line_number_checkbox = (CheckBox) findViewById(R.id.line_number_checkbox);
        this.repeated_output = (TextView) findViewById(R.id.repeated_output);
        this.ic_whats_share = (ImageView) findViewById(R.id.ic_whats_share);
        this.vscroll1 = (LinearLayout) findViewById(R.id.vscroll1);
        this.iv_copy_text = (ImageView) findViewById(R.id.iv_copy_text);
        this.iv_delete_text = (ImageView) findViewById(R.id.iv_delete_text);
        this.vibrator = (Vibrator) getSystemService("vibrator");
        this.data = getSharedPreferences("data", 0);
        this.ln_repeat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Text_Repeater.this.vscroll1.setVisibility(0);
                Activity_Text_Repeater.this._vibrate();
                if (Activity_Text_Repeater.this.repeat_input.getText().toString().equals("") || Activity_Text_Repeater.this.how_many_input.getText().toString().equals("")) {
                    Activity_Text_Repeater.this.showMessage("Enter your text and how many repetitions");
                    return;
                }
                Activity_Text_Repeater.this.text_to_repeat = "";
                Activity_Text_Repeater.this.text_repeat = "";
                Activity_Text_Repeater.this.line_number = 1.0d;
                Activity_Text_Repeater.this.first_repeat = true;
                Activity_Text_Repeater activity_Text_Repeater = Activity_Text_Repeater.this;
                activity_Text_Repeater.repeat = Double.parseDouble(activity_Text_Repeater.how_many_input.getText().toString());
                Activity_Text_Repeater activity_Text_Repeater2 = Activity_Text_Repeater.this;
                activity_Text_Repeater2.text_to_repeat = activity_Text_Repeater2.repeat_input.getText().toString();
                if (((double) Activity_Text_Repeater.this.text_to_repeat.length()) * Activity_Text_Repeater.this.repeat > 100000.0d) {
                    Activity_Text_Repeater.this.showMessage("Character limit will be exceeded, try fewer repetitions");
                    return;
                }
                if (Activity_Text_Repeater.this.space_checkbox.isChecked()) {
                    for (int i = 0; i < ((int) Activity_Text_Repeater.this.repeat); i++) {
                        if (Activity_Text_Repeater.this.first_repeat) {
                            Activity_Text_Repeater activity_Text_Repeater3 = Activity_Text_Repeater.this;
                            activity_Text_Repeater3.text_repeat = activity_Text_Repeater3.text_to_repeat;
                            Activity_Text_Repeater.this.first_repeat = false;
                        } else {
                            Activity_Text_Repeater activity_Text_Repeater4 = Activity_Text_Repeater.this;
                            activity_Text_Repeater4.text_repeat = activity_Text_Repeater4.text_repeat.concat(" ".concat(Activity_Text_Repeater.this.text_to_repeat));
                        }
                    }
                } else if (!Activity_Text_Repeater.this.line_checkbox.isChecked()) {
                    for (int i2 = 0; i2 < ((int) Activity_Text_Repeater.this.repeat); i2++) {
                        if (Activity_Text_Repeater.this.first_repeat) {
                            Activity_Text_Repeater activity_Text_Repeater5 = Activity_Text_Repeater.this;
                            activity_Text_Repeater5.text_repeat = activity_Text_Repeater5.text_to_repeat;
                            Activity_Text_Repeater.this.first_repeat = false;
                        } else {
                            Activity_Text_Repeater activity_Text_Repeater6 = Activity_Text_Repeater.this;
                            activity_Text_Repeater6.text_repeat = activity_Text_Repeater6.text_repeat.concat("".concat(Activity_Text_Repeater.this.text_to_repeat));
                        }
                    }
                } else if (Activity_Text_Repeater.this.line_number_checkbox.isChecked()) {
                    for (int i3 = 0; i3 < ((int) Activity_Text_Repeater.this.repeat); i3++) {
                        if (Activity_Text_Repeater.this.first_repeat) {
                            Activity_Text_Repeater activity_Text_Repeater7 = Activity_Text_Repeater.this;
                            activity_Text_Repeater7.text_repeat = "1. ".concat(activity_Text_Repeater7.text_to_repeat);
                            Activity_Text_Repeater.this.first_repeat = false;
                            Activity_Text_Repeater.this.line_number += 1.0d;
                        } else {
                            Activity_Text_Repeater activity_Text_Repeater8 = Activity_Text_Repeater.this;
                            activity_Text_Repeater8.text_repeat = activity_Text_Repeater8.text_repeat.concat(IOUtils.LINE_SEPARATOR_UNIX.concat(String.valueOf((long) Activity_Text_Repeater.this.line_number).concat(".".concat(" ".concat(Activity_Text_Repeater.this.text_to_repeat)))));
                            Activity_Text_Repeater.this.line_number += 1.0d;
                        }
                    }
                } else {
                    for (int i4 = 0; i4 < ((int) Activity_Text_Repeater.this.repeat); i4++) {
                        if (Activity_Text_Repeater.this.first_repeat) {
                            Activity_Text_Repeater activity_Text_Repeater9 = Activity_Text_Repeater.this;
                            activity_Text_Repeater9.text_repeat = activity_Text_Repeater9.text_to_repeat;
                            Activity_Text_Repeater.this.first_repeat = false;
                        } else {
                            Activity_Text_Repeater activity_Text_Repeater10 = Activity_Text_Repeater.this;
                            activity_Text_Repeater10.text_repeat = activity_Text_Repeater10.text_repeat.concat(IOUtils.LINE_SEPARATOR_UNIX.concat(Activity_Text_Repeater.this.text_to_repeat));
                        }
                    }
                }
                Activity_Text_Repeater.this.repeated_output.setText(Activity_Text_Repeater.this.text_repeat);
                Activity_Text_Repeater.this._save_history();
            }
        });
        this.how_many_input.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.toString().contains("-")) {
                    Activity_Text_Repeater.this.how_many_input.setText("");
                }
            }
        });
        this.space_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    Activity_Text_Repeater.this.line_number_checkbox.setVisibility(4);
                    Activity_Text_Repeater.this.line_checkbox.setChecked(false);
                    Activity_Text_Repeater.this.line_number_checkbox.setChecked(false);
                    Activity_Text_Repeater.this.data.edit().putString("space", "on").commit();
                    return;
                }
                Activity_Text_Repeater.this.data.edit().putString("space", "off").commit();
            }
        });
        this.line_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    Activity_Text_Repeater.this.space_checkbox.setChecked(false);
                    Activity_Text_Repeater.this.line_number_checkbox.setVisibility(0);
                    Activity_Text_Repeater.this.data.edit().putString("newline", "on").commit();
                    return;
                }
                Activity_Text_Repeater.this.line_number_checkbox.setChecked(false);
                Activity_Text_Repeater.this.line_number_checkbox.setVisibility(4);
                Activity_Text_Repeater.this.data.edit().putString("newline", "off").commit();
            }
        });
        this.line_number_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    Activity_Text_Repeater.this.data.edit().putString("numbers", "on").commit();
                } else {
                    Activity_Text_Repeater.this.data.edit().putString("numbers", "off").commit();
                }
            }
        });
        this.iv_delete_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Text_Repeater.this.repeat_input.setText("");
                Activity_Text_Repeater.this.how_many_input.setText("");
                Activity_Text_Repeater.this.repeated_output.setText("");
                Activity_Text_Repeater.this.repeat = 0.0d;
                Activity_Text_Repeater.this.text_to_repeat = "";
                Activity_Text_Repeater.this.text_repeat = "";
                Activity_Text_Repeater.this.line_number = 1.0d;
                Activity_Text_Repeater.this.first_repeat = true;
            }
        });
        this.iv_copy_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Activity_Text_Repeater.this.repeated_output.getText().toString().length() > 0) {
                    Activity_Text_Repeater.this.getApplicationContext();
                    ((ClipboardManager) Activity_Text_Repeater.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("clipboard", Activity_Text_Repeater.this.repeated_output.getText().toString()));
                    Toast.makeText(Activity_Text_Repeater.this, "Text Copied!", 0).show();
                }
            }
        });
        this.ic_whats_share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.setPackage("com.whatsapp");
                intent.putExtra("android.intent.extra.TEXT", Activity_Text_Repeater.this.repeated_output.getText().toString());
                if (intent.resolveActivity(Activity_Text_Repeater.this.getPackageManager()) == null) {
                    Toast.makeText(Activity_Text_Repeater.this, "Whatsapp not installed.", 0).show();
                } else {
                    Activity_Text_Repeater.this.startActivity(intent);
                }
            }
        });
    }

    public void onBackPressed() {

        super.onBackPressed();

    }

    private void initializeLogic() {
        this.line_number_checkbox.setVisibility(4);
        this.line_number = 1.0d;
    }

    public void onActivityResult(int i, int i2, Intent intent2) {
        super.onActivityResult(i, i2, intent2);
    }

    public void onStart() {
        super.onStart();
        if (this.data.getString("historyindex", "").equals("")) {
            this.history_index = 0.0d;
        } else {
            this.history_index = Double.parseDouble(this.data.getString("historyindex", ""));
        }
    }

    @SuppressLint("MissingPermission")
    public void _vibrate() {
        this.vibrator.vibrate(30);
    }

    public void _save_history() {
        this.calendar = Calendar.getInstance();
        this.data.edit().putString(String.valueOf((long) this.history_index).concat("text"), this.repeat_input.getText().toString()).commit();
        this.data.edit().putString(String.valueOf((long) this.history_index).concat("reps"), this.how_many_input.getText().toString()).commit();
        this.data.edit().putString(String.valueOf((long) this.history_index).concat("date"), new SimpleDateFormat("dd MMM yyyy").format(this.calendar.getTime()).concat(" ".concat(new SimpleDateFormat("HH:mm").format(this.calendar.getTime())))).commit();
        this.history_index += 1.0d;
        this.data.edit().putString("historyindex", String.valueOf((long) this.history_index)).commit();
    }

    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Deprecated
    public int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList<Double> arrayList = new ArrayList<>();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf((double) checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i) {
        return TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
