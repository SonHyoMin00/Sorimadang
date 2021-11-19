package com.example.myapplication.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.InstrumentQuizIntroActivity;
import com.example.myapplication.MinyoGameStage;
import com.example.myapplication.OXquizIntroActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<ListviewComponent> ListviewComponents;
    ListView customListView;
    private static CustomAdapter customAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container,false);

        ListviewComponents = new ArrayList<>();
        ListviewComponents.add(new ListviewComponent("너 이름이 뭐니?", "국악기의 이름을 맞혀주세요",R.drawable.janggu , Color.parseColor("#DADADA")));
        ListviewComponents.add(new ListviewComponent("국악기 OX 퀴즈", "나 국악기 좀 안다! 도전해보세요", R.drawable.oxquiz,Color.parseColor("#F8F8F8")));
        ListviewComponents.add(new ListviewComponent("민요 맞히기", "아기 도드리를 찾아주세요!", R.drawable.musicnotes,Color.parseColor("#DADADA")));
        ListviewComponents.add(new ListviewComponent("하늘에서 음표가\n떨어진다면", "음표를 얻고 국악기를 완성하세요!", R.drawable.musicnote2,Color.parseColor("#F8F8F8")));

        customListView = (ListView) root.findViewById(R.id.main_listview);
        customAdapter = new CustomAdapter(getContext(),ListviewComponents);

        customListView.setAdapter(customAdapter);
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //각 아이템을 분간 할 수 있는 position과 뷰
                switch (position) {
                    case 0:
                        Intent intent0 = new Intent(getActivity(), InstrumentQuizIntroActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), OXquizIntroActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), MinyoGameStage.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Toast.makeText(getActivity(),"toast 3",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        return root;
    }
}