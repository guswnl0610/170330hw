package com.example.guswn_000.a170330hw;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by guswn_000 on 2017-03-30.
 */

public class Fragment1 extends Fragment implements View.OnClickListener
{
    Button apple,grape,kiwi,jamong , revise, first, initialize;
    Table t1,t2,t3,t4;
    TextView tvtable, tvtime, tvpasta,tvpizza, tvmembership,tvprice;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View fragview = inflater.inflate(R.layout.fragment1,container,false);
        apple = (Button)fragview.findViewById(R.id.applebtn);
        grape = (Button)fragview.findViewById(R.id.grapebtn);
        kiwi = (Button)fragview.findViewById(R.id.kiwibtn);
        jamong = (Button)fragview.findViewById(R.id.jamongbtn);
        revise = (Button)fragview.findViewById(R.id.button6);
        first = (Button)fragview.findViewById(R.id.button5);
        initialize = (Button)fragview.findViewById(R.id.button7); //버튼
        tvtable = (TextView)fragview.findViewById(R.id.tvtable);
        tvtime = (TextView)fragview.findViewById(R.id.tvtime);
        tvpasta = (TextView)fragview.findViewById(R.id.tvpasta);
        tvpizza = (TextView)fragview.findViewById(R.id.tvpizza);
        tvmembership = (TextView)fragview.findViewById(R.id.tvmemebership);
        tvprice = (TextView)fragview.findViewById(R.id.tvprice); //텍스트뷰
        apple.setOnClickListener(this);
        grape.setOnClickListener(this);
        kiwi.setOnClickListener(this);
        jamong.setOnClickListener(this);
        revise.setOnClickListener(this);
        first.setOnClickListener(this);
        initialize.setOnClickListener(this);
        return fragview;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.applebtn:
                tvtable.setText("사과테이블");
                if(t1 == null) //데이터가 없으면
                {thisisempty();}
                else
                {showtable();}
                break;
            case R.id.grapebtn:
                tvtable.setText("포도테이블");
                if(t2 == null)
                {thisisempty();}
                else
                {showtable();}
                break;
            case R.id.kiwibtn:
                tvtable.setText("키위테이블");
                if(t3 == null)
                {thisisempty();}
                else
                {showtable();}
                break;
            case R.id.jamongbtn:
                tvtable.setText("자몽테이블");
                if(t4 == null)
                {thisisempty();}
                else
                {showtable();}
                break;
            case R.id.button5://새 주문
                final View view = View.inflate(getActivity(),R.layout.dlglayout,null);
                EditText pastanum = (EditText)view.findViewById(R.id.pastanum);
                EditText pizzanum = (EditText)view.findViewById(R.id.pizzanum);
                EditText whatmembership = (EditText)view.findViewById(R.id.memberet);
                AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                dlg.setTitle("새 주문")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Snackbar.make(view,"정보가 입력되었습니다.",1000).setAction("확인",null);
                            }
                        })
                        .setNegativeButton("닫기",null)
                        .show();
                if(tvtable.getText().equals("사과테이블"))
                {
                    t1 = new Table("사과테이블", Integer.parseInt(pastanum.getText().toString()), Integer.parseInt(pizzanum.getText().toString()), Integer.parseInt(whatmembership.getText().toString()));
                    apple.setText("사과 TABLE");
                }
                else if(tvtable.getText().equals("포도테이블"))
                {
                    t2 = new Table("포도테이블", Integer.parseInt(pastanum.getText().toString()), Integer.parseInt(pizzanum.getText().toString()), Integer.parseInt(whatmembership.getText().toString()));
                    grape.setText("포도 TABLE");
                }
                else if(tvtable.getText().equals("키위테이블"))
                {
                    t3 = new Table("키위테이블", Integer.parseInt(pastanum.getText().toString()), Integer.parseInt(pizzanum.getText().toString()), Integer.parseInt(whatmembership.getText().toString()));
                    kiwi.setText("키위 TABLE");
                }
                else if(tvtable.getText().equals("자몽테이블"))
                {
                    t4 = new Table("자몽테이블", Integer.parseInt(pastanum.getText().toString()), Integer.parseInt(pizzanum.getText().toString()), Integer.parseInt(whatmembership.getText().toString()));
                    jamong.setText("자몽 TABLE");
                }
                showtable();
                break;
            case R.id.button6://수정
                final View view2 = View.inflate(getActivity(),R.layout.dlglayout,null);
                EditText pastanum2 = (EditText)view2.findViewById(R.id.pastanum);
                EditText pizzanum2 = (EditText)view2.findViewById(R.id.pizzanum);
                EditText whatmembership2 = (EditText)view2.findViewById(R.id.memberet);
                AlertDialog.Builder dlg2 = new AlertDialog.Builder(getActivity());
                dlg2.setTitle("주문 수정")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Snackbar.make(view2,"정보가 입력되었습니다.",1000).setAction("확인",null);
                            }
                        })
                        .setNegativeButton("닫기",null)
                        .show();
                if(tvtable.getText().equals("사과테이블"))
                {
                    t1 = new Table("사과테이블", Integer.parseInt(pastanum2.getText().toString()), Integer.parseInt(pizzanum2.getText().toString()), Integer.parseInt(whatmembership2.getText().toString()));
                }
                else if(tvtable.getText().equals("포도테이블"))
                {
                    t2 = new Table("포도테이블", Integer.parseInt(pastanum2.getText().toString()), Integer.parseInt(pizzanum2.getText().toString()), Integer.parseInt(whatmembership2.getText().toString()));
                }
                else if(tvtable.getText().equals("키위테이블"))
                {
                    t3 = new Table("키위테이블", Integer.parseInt(pastanum2.getText().toString()), Integer.parseInt(pizzanum2.getText().toString()), Integer.parseInt(whatmembership2.getText().toString()));
                }
                else if(tvtable.getText().equals("자몽테이블"))
                {
                    t4 = new Table("자몽테이블", Integer.parseInt(pastanum2.getText().toString()), Integer.parseInt(pizzanum2.getText().toString()), Integer.parseInt(whatmembership2.getText().toString()));
                }
                showtable();
                break;
            case R.id.button7://초기화
                if(tvtable.getText().equals("사과테이블"))
                {
                    t1 = null;
                    apple.setText("사과 TABLE (비어있음)");
                }
                else if(tvtable.getText().equals("포도테이블"))
                {
                    t2 = null;
                    apple.setText("포도 TABLE (비어있음)");
                }
                else if(tvtable.getText().equals("키위테이블"))
                {
                    t3 = null;
                    apple.setText("키위 TABLE (비어있음)");
                }
                else if(tvtable.getText().equals("자몽테이블"))
                {
                    t4 = null;
                    apple.setText("자몽 TABLE (비어있음)");
                }
                break;
        }
    }

    public void thisisempty() //비어있는 Table일때 Toast
    {
        Toast.makeText(getActivity(), "비어있는 테이블입니다.", Toast.LENGTH_SHORT).show();
        first.setEnabled(true);
        revise.setEnabled(false);
        initialize.setEnabled(false);
    }
    public void showtable() // 비어있지 않은경우 Table의 정보 출력
    {
        first.setEnabled(false);
        revise.setEnabled(true);
        initialize.setEnabled(true);
        int totalprice;
        if(tvtable.getText().equals("사과테이블"))
        {
            tvpasta.setText( t1.pasta );
            tvpizza.setText( t1.pizza );
            tvtime.setText("년월일 시간 입력하긔"); // 지금말고..좀 있다가 하긔
            totalprice = t1.pasta * 10000 + t1.pizza * 12000;
            if(t1.membership == 0)
            {
                tvmembership.setText("기본 멤버쉽");
                tvprice.setText(totalprice*(0.9) + "원");
            }
            else if (t1.membership == 1)
            {
                tvmembership.setText("VIP 멤버쉽");
                tvprice.setText(totalprice*(0.7) + "원");
            }
            else
            {
                tvmembership.setText("멤버쉽 없음");
                tvprice.setText(totalprice + "원");
            }
        }
        else if(tvtable.getText().equals("포도테이블"))
        {
            tvpasta.setText( t2.pasta );
            tvpizza.setText( t2.pizza );
            tvtime.setText("년월일 시간 입력하긔"); // 지금말고..좀 있다가 하긔
            totalprice = t2.pasta * 10000 + t2.pizza * 12000;
            if(t2.membership == 0)
            {
                tvmembership.setText("기본 멤버쉽");
                tvprice.setText(totalprice*(0.9) + "원");
            }
            else if (t2.membership == 1)
            {
                tvmembership.setText("VIP 멤버쉽");
                tvprice.setText(totalprice*(0.7) + "원");
            }
            else
            {
                tvmembership.setText("멤버쉽 없음");
                tvprice.setText(totalprice + "원");
            }
        }
        else if(tvtable.getText().equals("키위테이블"))
        {
            tvpasta.setText( t3.pasta );
            tvpizza.setText( t3.pizza );
            tvtime.setText("년월일 시간 입력하긔"); // 지금말고..좀 있다가 하긔
            totalprice = t3.pasta * 10000 + t3.pizza * 12000;
            if(t3.membership == 0)
            {
                tvmembership.setText("기본 멤버쉽");
                tvprice.setText(totalprice*(0.9) + "원");
            }
            else if (t3.membership == 1)
            {
                tvmembership.setText("VIP 멤버쉽");
                tvprice.setText(totalprice*(0.7) + "원");
            }
            else
            {
                tvmembership.setText("멤버쉽 없음");
                tvprice.setText(totalprice + "원");
            }
        }
        else if(tvtable.getText().equals("자몽테이블"))
        {
            tvpasta.setText( t4.pasta );
            tvpizza.setText( t4.pizza );
            tvtime.setText("년월일 시간 입력하긔"); // 지금말고..좀 있다가 하긔
            totalprice = t4.pasta * 10000 + t4.pizza * 12000;
            if(t4.membership == 0)
            {
                tvmembership.setText("기본 멤버쉽");
                tvprice.setText(totalprice*(0.9) + "원");
            }
            else if (t4.membership == 1)
            {
                tvmembership.setText("VIP 멤버쉽");
                tvprice.setText(totalprice*(0.7) + "원");
            }
            else
            {
                tvmembership.setText("멤버쉽 없음");
                tvprice.setText(totalprice + "원");
            }
        }
    }


//    public void newtable()
//    {
//        final View view = View.inflate(getActivity(),R.layout.dlglayout,null);
//        final EditText pastanum = (EditText)view.findViewById(R.id.pastanum);
//        final EditText pizzanum = (EditText)view.findViewById(R.id.pizzanum);
//        final EditText whatmembership = (EditText)view.findViewById(R.id.memberet);
//        AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
//        dlg.setTitle("새 주문")
//                .setView(view)
//                .setPositiveButton("확인", new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which)
//                    {
//                        //
//                        Snackbar.make(view,"정보가 입력되었습니다",1000).setAction("확인",null);
//                    }
//                })
//                .setNegativeButton("닫기",null)
//                .show();
//    }이거어케해 ㅡㅡ

}

