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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by guswn_000 on 2017-03-30.
 */

public class Fragment1 extends Fragment implements View.OnClickListener
{
    Button apple,grape,kiwi,jamong , revise, first, initialize;
    Table t1,t2,t3,t4;
    TextView tvtable, tvtime, tvpasta,tvpizza, tvmembership,tvprice;
    int npiz,npas;
    RadioButton checkedrb;
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
    public void onClick(final View v)
    {
        switch (v.getId())
        {
            case R.id.applebtn:
                cleaner();
                tvtable.setText("사과테이블");
                if(t1 == null) //데이터가 없으면
                {thisisempty();}
                else
                {showtable2(t1);}
                break;
            case R.id.grapebtn:
                cleaner();
                tvtable.setText("포도테이블");
                if(t2 == null)
                {thisisempty();}
                else
                {showtable2(t2);}
                break;
            case R.id.kiwibtn:
                cleaner();
                tvtable.setText("키위테이블");
                if(t3 == null)
                {thisisempty();}
                else
                {showtable2(t3);}
                break;
            case R.id.jamongbtn:
                cleaner();
                tvtable.setText("자몽테이블");
                if(t4 == null)
                {thisisempty();}
                else
                {showtable2(t4);}
                break;
            case R.id.button5://새 주문
                View dlgview = View.inflate(v.getContext(),R.layout.dlglayout,null);
                final EditText pastanum = (EditText)dlgview.findViewById(R.id.pastanum);
                final EditText pizzanum = (EditText)dlgview.findViewById(R.id.pizzanum);
                final RadioButton rb1 = (RadioButton)dlgview.findViewById(R.id.radioButton);
                final RadioButton rb2 = (RadioButton)dlgview.findViewById(R.id.radioButton2);
                AlertDialog.Builder dlg = new AlertDialog.Builder(v.getContext());
                dlg.setView(dlgview)
                        .setTitle("새 주문")
                        .setNegativeButton("닫기",null)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                if (pastanum.getText().toString().equals("") || pizzanum.getText().toString().equals(""))
                                {
                                    if(pastanum.getText().toString().equals("") && (!pizzanum.getText().toString().equals("")))
                                    {
                                        npas = 0;
                                        npiz = Integer.parseInt(pizzanum.getText().toString());
                                    }
                                    else if ( !pastanum.getText().toString().equals("") && pizzanum.getText().toString().equals(""))
                                    {
                                        npas = Integer.parseInt(pastanum.getText().toString());
                                        npiz = 0;
                                    }
                                    else if (pastanum.getText().toString().equals("") && pizzanum.getText().toString().equals(""))
                                    {
                                        npas = 0;
                                        npiz = 0;
                                    }
                                }
                                else
                                {
                                    npas = Integer.parseInt(pastanum.getText().toString());
                                    npiz = Integer.parseInt(pizzanum.getText().toString());
                                }
                                if(tvtable.getText().toString().equals("사과테이블"))
                                {
                                    if(rb1.isChecked())
                                    {
                                        t1 = new Table ("사과테이블",npas,npiz,"기본 멤버쉽",finddate());
                                    }
                                    else if (rb2.isChecked())
                                    {
                                        t1 = new Table ("사과테이블",npas,npiz,"VIP 멤버쉽",finddate());
                                    }
                                    apple.setText("사과 TABLE");
                                    showtable2(t1);
                                }
                                else if(tvtable.getText().toString().equals("포도테이블"))
                                {
                                    if(rb1.isChecked())
                                    {
                                        t2 = new Table ("포도테이블",npas,npiz,"기본 멤버쉽",finddate());
                                    }
                                    else if (rb2.isChecked())
                                    {
                                        t2 = new Table ("포도테이블",npas,npiz,"VIP 멤버쉽",finddate());
                                    }
                                    grape.setText("포도 TABLE");
                                    showtable2(t2);
                                }
                                else if(tvtable.getText().toString().equals("키위테이블"))
                                {
                                    if(rb1.isChecked())
                                    {
                                        t3 = new Table ("키위테이블",npas,npiz,"기본 멤버쉽",finddate());
                                    }
                                    else if (rb2.isChecked())
                                    {
                                        t3 = new Table ("키위테이블",npas,npiz,"VIP 멤버쉽",finddate());
                                    }
                                    kiwi.setText("키위 TABLE");
                                    showtable2(t3);
                                }
                                else if(tvtable.getText().toString().equals("자몽테이블"))
                                {
                                    if(rb1.isChecked())
                                    {
                                        t4 = new Table ("자몽테이블",npas,npiz,"기본 멤버쉽",finddate());
                                    }
                                    else if (rb2.isChecked())
                                    {
                                        t4 = new Table ("자몽테이블",npas,npiz,"VIP 멤버쉽",finddate());
                                    }
                                    jamong.setText("자몽 TABLE");
                                    showtable2(t4);
                                }
                                Snackbar.make(v,"정보가 입력되었습니다",2000).show();
                            }
                        })
                        .show();
                break;
            case R.id.button6://수정
                View dlgview2 = View.inflate(v.getContext(),R.layout.dlglayout,null);
                final EditText pastanum2 = (EditText)dlgview2.findViewById(R.id.pastanum);
                final EditText pizzanum2 = (EditText)dlgview2.findViewById(R.id.pizzanum);
                final RadioButton rb3 = (RadioButton)dlgview2.findViewById(R.id.radioButton);
                final RadioButton rb4 = (RadioButton)dlgview2.findViewById(R.id.radioButton2);
                AlertDialog.Builder dlg2 = new AlertDialog.Builder(v.getContext());
                dlg2.setView(dlgview2)
                        .setTitle("주문 수정")
                        .setNegativeButton("닫기",null)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {if (pastanum2.getText().toString().equals("") || pizzanum2.getText().toString().equals(""))
                            {
                                if(pastanum2.getText().toString().equals("") && (!pizzanum2.getText().toString().equals("")))
                                {
                                    npas = 0;
                                    npiz = Integer.parseInt(pizzanum2.getText().toString());
                                }
                                else if ( !pastanum2.getText().toString().equals("") && pizzanum2.getText().toString().equals(""))
                                {
                                    npas = Integer.parseInt(pastanum2.getText().toString());
                                    npiz = 0;
                                }
                                else if (pastanum2.getText().toString().equals("") && pizzanum2.getText().toString().equals(""))
                                {
                                    npas = 0;
                                    npiz = 0;
                                }
                            }
                                else
                                {
                                    npas = Integer.parseInt(pastanum2.getText().toString());
                                    npiz = Integer.parseInt(pizzanum2.getText().toString());
                                }
                                if(tvtable.getText().toString().equals("사과테이블"))
                                {
                                    if(rb3.isChecked())
                                    {
                                        t1 = new Table ("사과테이블",npas,npiz,"기본 멤버쉽",finddate());
                                    }
                                    else if (rb4.isChecked())
                                    {
                                        t1 = new Table ("사과테이블",npas,npiz,"VIP 멤버쉽",finddate());
                                    }
                                    apple.setText("사과 TABLE");
                                    showtable2(t1);
                                }
                                else if(tvtable.getText().toString().equals("포도테이블"))
                                {
                                    if(rb3.isChecked())
                                    {
                                        t2 = new Table ("포도테이블",npas,npiz,"기본 멤버쉽",finddate());
                                    }
                                    else if (rb4.isChecked())
                                    {
                                        t2 = new Table ("포도테이블",npas,npiz,"VIP 멤버쉽",finddate());
                                    }
                                    grape.setText("포도 TABLE");
                                    showtable2(t2);
                                }
                                else if(tvtable.getText().toString().equals("키위테이블"))
                                {
                                    if(rb3.isChecked())
                                    {
                                        t3 = new Table ("키위테이블",npas,npiz,"기본 멤버쉽",finddate());
                                    }
                                    else if (rb4.isChecked())
                                    {
                                        t3 = new Table ("키위테이블",npas,npiz,"VIP 멤버쉽",finddate());
                                    }
                                    kiwi.setText("키위 TABLE");
                                    showtable2(t3);
                                }
                                else if(tvtable.getText().toString().equals("자몽테이블"))
                                {
                                    if(rb3.isChecked())
                                    {
                                        t4 = new Table ("자몽테이블",npas,npiz,"기본 멤버쉽",finddate());
                                    }
                                    else if (rb4.isChecked())
                                    {
                                        t4 = new Table ("자몽테이블",npas,npiz,"VIP 멤버쉽",finddate());
                                    }
                                    jamong.setText("자몽 TABLE");
                                    showtable2(t4);
                                }
                                Snackbar.make(v,"정보가 입력되었습니다",2000).show();
                            }
                        })
                        .show();
                break;
            case R.id.button7://초기화
                if(tvtable.getText().toString().equals("사과테이블"))
                {
                    t1 = null;
                    apple.setText("사과 TABLE (비어있음)");
                    cleaner();
                }
                else if(tvtable.getText().toString().equals("포도테이블"))
                {
                    t2 = null;
                    grape.setText("포도 TABLE (비어있음)");
                    cleaner();
                }
                else if(tvtable.getText().toString().equals("키위테이블"))
                {
                    t3 = null;
                    kiwi.setText("키위 TABLE (비어있음)");
                    cleaner();
                }
                else if(tvtable.getText().toString().equals("자몽테이블"))
                {
                    t4 = null;
                    jamong.setText("자몽 TABLE (비어있음)");
                    cleaner();
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
    public void showtable2(Table t)
    {
        first.setEnabled(false);
        revise.setEnabled(true);
        initialize.setEnabled(true);
        int price = t.getPasta()*10000 + t.getPizza()*12000;
        tvpasta.setText(t.getPasta()+"");
        tvpizza.setText(t.getPizza()+"");
        tvtime.setText(t.getDate()+"");
        tvmembership.setText(t.getMembership());
        if(t.getMembership().equals("기본 멤버쉽"))
        {
            tvprice.setText(price * 0.9 + "원");
        }
        else
        {
            tvprice.setText(price * 0.7 + "원");
        }
    }
    public void cleaner()
    {
        tvtable.setText(null);
        tvtime.setText(null);
        tvmembership.setText(null);
        tvprice.setText(null);
        tvpasta.setText(null);
        tvpizza.setText(null);
        initialize.setEnabled(false);
        first.setEnabled(false);
        revise.setEnabled(false);
    }
    public String finddate()
    {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fmdate = sdf.format(date);
        return fmdate;
    }
}