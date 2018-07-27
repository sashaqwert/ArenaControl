package ru.sccraft.arenacontrol;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.ads.AdView;

public class PlayerActivity extends ADsActivity {

    private Server сервер;
    private String игрок;
    private EditText сообщение;
    AdView adview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        сервер = Server.fromJSON(getIntent().getStringExtra("server"));
        игрок = getIntent().getStringExtra("name");
        setTitle(игрок);
        сообщение = findViewById(R.id.player_message);
        adview = findViewById(R.id.adView);
        задать_баннер(adview);
    }

    public void kick(View view) {
        String сообщение = this.сообщение.getText().toString();
        if (сообщение.equals("")) {
            сервер.выполнить_комманду("kick " + игрок + " " + getString(R.string.player_kickByApp));
        } else {
            сервер.выполнить_комманду("kick " + игрок + " " + сообщение);
        }
    }

    public void ban(View view) {
        String сообщение = this.сообщение.getText().toString();
        if (сообщение.equals("")) {
            сервер.выполнить_комманду("ban " + игрок + " " + getString(R.string.player_kickByApp));
        } else {
            сервер.выполнить_комманду("ban " + игрок + " " + сообщение);
        }
    }

    public void op(View view) {
        сервер.выполнить_комманду("op " + игрок);
    }

    public void deOP(View view) {
        сервер.выполнить_комманду("deop " + игрок);
    }

    public void kill(View view) {
        сервер.выполнить_комманду("kill " + игрок);
    }

    public void gameMode_survival(View view) {
        if (сервер.геймМод_1_13)
            сервер.выполнить_комманду("gamemode survival " + игрок);
        else
            сервер.выполнить_комманду("gamemode 0 " + игрок);
    }

    public void gameMode_creative(View view) {
        if (сервер.геймМод_1_13)
            сервер.выполнить_комманду("gamemode creative " + игрок);
        else
            сервер.выполнить_комманду("gamemode 1 " + игрок);
    }

    public void gameMode_gameMode_adventure(View view) {
        if (сервер.геймМод_1_13)
            сервер.выполнить_комманду("gamemode adventure " + игрок);
        else
            сервер.выполнить_комманду("gamemode 2 " + игрок);
    }

    public void gameMode_observer(View view) {
        if (сервер.геймМод_1_13)
            сервер.выполнить_комманду("gamemode spectator " + игрок);
        else
            сервер.выполнить_комманду("gamemode 3 " + игрок);
    }

    public void whitelistAdd(View view) {
        сервер.выполнить_комманду("whitelist add " + игрок);
    }

    public void whitelistRemove(View view) {
        сервер.выполнить_комманду("whitelist remove " + игрок);
    }
}
