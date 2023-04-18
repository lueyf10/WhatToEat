package my.edu.utar.ga;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        createExampleList();
        buildRecyclerView();

        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }

    private void filter(String text) {
        ArrayList<ExampleItem> filteredList = new ArrayList<>();

        for (ExampleItem item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }

    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.mcdonald, "Mcdonald", "Categories : Fast Food"));
        mExampleList.add(new ExampleItem(R.drawable.kfc, "KFC", "Categories : Fast Food"));
        mExampleList.add(new ExampleItem(R.drawable.karim, "Karim", "Categories : Fast Food"));
        mExampleList.add(new ExampleItem(R.drawable.domino, "Domino", "Categories : Fast Food"));
        mExampleList.add(new ExampleItem(R.drawable.secret_coffee, "Secret Coffee", "Categories : Fast Food"));
        mExampleList.add(new ExampleItem(R.drawable.secret_recipe, "Secret Recipe", "Categories : Fast Food"));
        mExampleList.add(new ExampleItem(R.drawable.sushi_mentai, "Sushi Mentai", "Categories : Fast Food"));
        mExampleList.add(new ExampleItem(R.drawable.thai_thai_thai, "Thai thai thai", "Categories : Fast Food"));
        mExampleList.add(new ExampleItem(R.drawable.rice_garden, "Rice Garden", "Categories : Fast Food"));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}