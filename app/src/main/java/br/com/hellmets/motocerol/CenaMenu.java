package br.com.hellmets.motocerol;

import br.com.hellmets.motocerol.AndGraph.AGGameManager;
import br.com.hellmets.motocerol.AndGraph.AGInputManager;
import br.com.hellmets.motocerol.AndGraph.AGScene;
import br.com.hellmets.motocerol.AndGraph.AGScreenManager;
import br.com.hellmets.motocerol.AndGraph.AGSprite;
import br.com.hellmets.motocerol.AndGraph.AGTimer;

/**
 * Created by Daniel Rodrigues on 17/11/2017.
 */

public class CenaMenu extends AGScene {

    AGSprite imgCampoJogoFundo = null;
    AGSprite btnGoBack = null;
    AGSprite btnTop = null;
    AGSprite btnTopper = null;
    AGSprite btnTopizeira = null;

    CenaMenu(AGGameManager manager){
        super(manager);
    }

    @Override
    public void init() { //Chamado toda vez que a cena Abertura é mostrada
        setSceneBackgroundColor(0,1,1);

        imgCampoJogoFundo = this.createSprite(R.mipmap.campo_jogo_fundo, 1, 1);
        imgCampoJogoFundo.setScreenPercent(100, 100); //Tamanho da imagem
        imgCampoJogoFundo.vrPosition.setXY (AGScreenManager.iScreenWidth/2, AGScreenManager.iScreenHeight/2);

        btnGoBack = this.createSprite(R.mipmap.btn_goback, 1, 1); //(imagem, linha, coluna)
        btnGoBack.setScreenPercent(20, 10); //Tamanho da imagem
        btnGoBack.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        btnGoBack.vrPosition.setY(AGScreenManager.iScreenHeight/10);

        btnTop = this.createSprite(R.mipmap.btn_top, 1, 1); //(imagem, linha, coluna)
        btnTop.setScreenPercent(50, 10); //Tamanho da imagem
        btnTop.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        btnTop.vrPosition.setY(btnTop.vrPosition.getY()+800);

        btnTopper = this.createSprite(R.mipmap.btn_topper, 1, 1); //(imagem, linha, coluna)
        btnTopper.setScreenPercent(50, 10); //Tamanho da imagem
        btnTopper.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        btnTopper.vrPosition.setY(btnTopper.vrPosition.getY()+600);

        btnTopizeira = this.createSprite(R.mipmap.btn_topizeira, 1, 1); //(imagem, linha, coluna)
        btnTopizeira.setScreenPercent(50, 10); //Tamanho da imagem
        btnTopizeira.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        btnTopizeira.vrPosition.setY(btnTopizeira.vrPosition.getY()+400);
    }

    @Override
    public void restart() { //Volta a aplicação para onde parou quando foi chamado o método stop

    }

    @Override
    public void stop() { //Para a aplicação enquanto a aplicação passa para segundo plano

    }

    @Override
    public void loop() {

        if(AGInputManager.vrTouchEvents.screenClicked()){ //Verifica se a tela foi tocada
            if(btnGoBack.collide(AGInputManager.vrTouchEvents.getLastPosition())){ //verifica se o toque foi dentro dos limites da imagem do botao
                this.vrGameManager.setCurrentScene(0);
                return;
            }
        }

        if(AGInputManager.vrTouchEvents.screenClicked()){ //Verifica se a tela foi tocada
            if(btnTop.collide(AGInputManager.vrTouchEvents.getLastPosition())){ //verifica se o toque foi dentro dos limites da imagem do botao
                this.vrGameManager.setCurrentScene(2);
                return;
            }
        }
    }
}