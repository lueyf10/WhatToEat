package my.edu.utar.ga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity {
    String RestaurantList[]={"McDonald","Sushi Mentai","Secret Coffee","Thai Thai Thai","Karim","Rice Garden","KFC","Domino","Secret Recipe"};
    int RestaurantImages [] ={R.drawable.mcdonald,R.drawable.sushi_mentai,R.drawable.secret_coffee,R.drawable.thai_thai_thai,R.drawable.karim,R.drawable.rice_garden,R.drawable.kfc,R.drawable.domino,R.drawable.secret_recipe};

    ListView listView;
    ImageView firstFragmentBtn, secondFragmentBtn,thirdFragmentBtn,fourthFragmentBtn,fifthFragmentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        firstFragmentBtn=findViewById(R.id.Favourite);
        secondFragmentBtn=findViewById(R.id.Search);
        thirdFragmentBtn=findViewById(R.id.main);
        fourthFragmentBtn=findViewById(R.id.Spin);
        fifthFragmentBtn=findViewById(R.id.Profile);

        listView =(ListView)findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter=new CustomBaseAdapter(getApplicationContext(),RestaurantList,RestaurantImages);
        listView.setAdapter(customBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position ==0){
                    startActivity(new Intent(MainActivity2.this,Mcdonald.class));
                }else if(position ==1){
                    startActivity(new Intent(MainActivity2.this,SushiMentai.class));
                }else if(position ==2){
                    startActivity(new Intent(MainActivity2.this,SecretCoffee.class));

                }else if(position ==3){
                    startActivity(new Intent(MainActivity2.this,ThaiThaiThai.class));

                }else if(position ==4){
                    startActivity(new Intent(MainActivity2.this,Karim.class));

                }else if(position ==5){
                    startActivity(new Intent(MainActivity2.this,RiceGarden.class));

                }else if(position ==6){
                    startActivity(new Intent(MainActivity2.this,KFC.class));

                }else if(position ==7){
                    startActivity(new Intent(MainActivity2.this,Domino.class));

                }else if(position ==8){
                    startActivity(new Intent(MainActivity2.this,SecretRecipe.class));

                }
            }
        });

        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity2.this,Favourite.class));
            }
        });

        secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity2.this,Search.class));
            }
        });
        thirdFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity2.this,MainActivity2.class));
            }
        });

        fourthFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity2.this,InputActivity.class));
            }
        });
        fifthFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity2.this,ProfileActivity.class));
            }
        });


    }
}