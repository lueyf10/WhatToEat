package my.edu.utar.ga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    String RestaurantList[]={"McDonald","Sushi Mentai","Secret Coffee","Thai Thai Thai","Karim","Rice Garden","KFC","Domino","Secret Recipe"};
    int RestaurantImages [] ={R.drawable.mcdonald,R.drawable.sushi_mentai,R.drawable.secret_coffee,R.drawable.thai_thai_thai,R.drawable.karim,R.drawable.rice_garden,R.drawable.kfc,R.drawable.domino,R.drawable.secret_recipe};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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

        /*List<String> list= new ArrayList<>();
        list.add("McDonald");
        list.add("Sushi Mentai");
        list.add("Secret Coffee");
        list.add("Thai Thai Thai");
        list.add("Karim");
        list.add("Rice Garden");
        list.add("KFC");
        list.add("Domino");
        list.add("Secret Recipe");

        ArrayAdapter arrayAdapter = new ArrayAdapter( )*/


    }
}