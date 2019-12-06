package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    TextView ali;
//    TextView date;
//    Button button;
    public static final int REQ_CODE = 12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FormInfo form = new FormInfo(this, R.id.forminfos);
        form.getInput_name().setTextColor(Color.rgb(255, 120, 0));
        form.getSubmit().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = form.getInput_phone().getText().toString().trim();
                String email = form.getInput_email().getText().toString().trim();
                String name = form.getInput_name().getText().toString().trim();

                if (form.isValdINput(null, null, null)){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    if (form.getCheckBox().isChecked()){
                        intent.putExtra("phone", phone);
                    }
                    startActivityForResult(intent, REQ_CODE);
                }
            }
        });
//        ali = findViewById(R.id.textView);
        //ali.setText("alisahraei");
//        date = findViewById(R.id.date);
//        button = findViewById(R.id.button);



//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                randomTextColor();
//            }
//        });




//        button.setOnClickListener(this);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (v.getId() == R.id.button){
//                    randomTextColor();
//                }
//            }
//        });





//        button.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                date.setVisibility(View.VISIBLE);
//                return true;
////                when return is false means onLongClick with onClick but return is ture means onLongClick without onClick
//            }
//        });



//        button.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(intent);
//                return true;
//            }
//        });
//        Toast.makeText(this, "MainActivity: onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE && resultCode == RESULT_OK){
                Toast.makeText(this, data.getStringExtra("message"), Toast.LENGTH_SHORT).show();
            }

        }

    //    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(this, "MainActivity: onStart", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onRestart() {
//        Toast.makeText(this, "MainActivity: onRestart", Toast.LENGTH_SHORT).show();
//        super.onRestart();
//    }
//
//    @Override
//    protected void onResume() {
//        Toast.makeText(this, "MainActivity: onResume", Toast.LENGTH_SHORT).show();
////        date.setText(new Date().toString());
//        super.onResume();
//    }
//
//    @Override
//    protected void onDestroy() {
//        Toast.makeText(this, "MainActivity: onDestroy", Toast.LENGTH_SHORT).show();
//        super.onDestroy();
//    }
//
//    @Override
//    protected void onStop() {
//        Toast.makeText(this, "MainActivity: onStop", Toast.LENGTH_SHORT).show();
//        super.onStop();
//    }

//    private void randomTextColor() {
//        Random random = new Random();
////        date.setTextColor(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        randomTextColor();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        SubMenu intentSubmenu = menu.addSubMenu("intent options");
          intentSubmenu.add("open browser").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
              @Override
              public boolean onMenuItemClick(MenuItem item) {
                  Intent intent = new Intent(Intent.ACTION_VIEW);
                  intent.setData(Uri.parse("http:..www.ermile.com"));
                  startActivity(intent);
                  return false;
              }
          });
          intentSubmenu.add("send sms").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
              @Override
              public boolean onMenuItemClick(MenuItem item) {
                  Intent intent = new Intent(Intent.ACTION_VIEW);
                  intent.setData(Uri.parse("sms:09123456789"));
                  intent.putExtra("sms_body", "hello world");
                  startActivity(intent);
                  return false;
              }
          });
          intentSubmenu.add("open dialer").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
              @Override
              public boolean onMenuItemClick(MenuItem item) {
                  Intent intent = new Intent(Intent.ACTION_DIAL);
                  intent.setData(Uri.parse("tel:09123456879"));
                  startActivity(intent);
                  return false;
              }
          });
          SubMenu mediadsubmenu = menu.addSubMenu("Media");
          mediadsubmenu.add("Imageview").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
              @Override
              public boolean onMenuItemClick(MenuItem item) {
                  startActivity(new Intent(MainActivity.this, ImageViewActivity.class));
                  return false;
              }
          });
          mediadsubmenu.add("vdeoview").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
              @Override
              public boolean onMenuItemClick(MenuItem item) {
                  startActivity(new Intent(MainActivity.this, VideoViewActivity.class));
                  return false;
              }
          });
          mediadsubmenu.add("audio player").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
              @Override
              public boolean onMenuItemClick(MenuItem item) {
                  startActivity(new Intent(MainActivity.this, AudioActivity.class));
                  return false;
              }
          });
          mediadsubmenu.add("connect3").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
              @Override
              public boolean onMenuItemClick(MenuItem item) {
                  startActivity(new Intent(MainActivity.this, play_ground.class));
                  return false;
              }
          });

//          dialog
          menu.add("Dialog").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
              @Override
              public boolean onMenuItemClick(MenuItem item) {
                  startActivity(new Intent(MainActivity.this, dialActivity.class));
                  return false;
              }
          });
//          list view
        SubMenu listSubmenu = menu.addSubMenu("listveiw");
        listSubmenu.add("simple list").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this, simplelistAcrivity.class));
                return false;
            }
        });
        listSubmenu.add("custom list").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this, CustomListActivity.class));
                return false;
            }
        });
        menu.add("Toast").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this, ToastActivity.class));
                return false;
            }
        });
        menu.add("RarioButton").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this, RadioButtonActivity.class));
                return false;
            }
        });
        menu.add("RatingBar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this, RatingBarActivity.class));
                return false;
            }
        });





//        menu.add("myitem1");
//        menu.add("myitem2");
//        SubMenu submenu = menu.addSubMenu("myitem3");
//        submenu.add("mysubmenu1");
//        submenu.add("mysubmenu2");
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onClick(View v) {

    }
}
