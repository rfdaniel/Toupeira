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

public class Abertura extends AGScene {

    AGTimer tempo = null;
    AGSprite imgCampoJogoFundo = null;
    AGSprite btnAjuda = null;
    AGSprite btnSobre = null;
    AGSprite btnNext = null; //imagem para botão play
    AGSprite imgToupeiraAbertura = null; //imagem para cena de abertura
    AGSprite imgLogoAbertura = null; //imagem para cena de abertura

    Abertura(AGGameManager manager){
        super(manager);
    }

    @Override
    public void init() { //Chamado toda vez que a cena Abertura é mostrada (iniciada). Aloca recursos
        setSceneBackgroundColor(0,1,1);

        tempo = new AGTimer(4000); //tempo recebe 4 segundos

        imgCampoJogoFundo = this.createSprite(R.mipmap.campo_jogo_fundo, 1, 1);
        imgCampoJogoFundo.setScreenPercent(100, 100); //Tamanho da imagem
        imgCampoJogoFundo.vrPosition.setXY (AGScreenManager.iScreenWidth/2, AGScreenManager.iScreenHeight/2);

        //IMAGEM DA LOGO NA CENA ABERTURA
        imgLogoAbertura = this.createSprite(R.mipmap.img_logo_abertura, 1, 1);
        imgLogoAbertura.setScreenPercent(60, 20); //Tamanho da imagem
        imgLogoAbertura.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        imgLogoAbertura.vrPosition.setY(imgLogoAbertura.vrPosition.getY()+1000);

        /*
        //IMAGEM DA TOUPEIRA NA CENA ABERTURA
        imgToupeiraAbertura = this.createSprite(R.mipmap.img_toupeira_abertura, 1, 1);
        imgToupeiraAbertura.setScreenPercent(30, 20); //Tamanho da imagem
        imgToupeiraAbertura.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        imgToupeiraAbertura.vrPosition.setY(imgToupeiraAbertura.vrPosition.getY()+600);
        */
        btnSobre = this.createSprite(R.mipmap.btn_sobre, 1, 1);
        btnSobre.setScreenPercent(20, 10); //Tamanho da imagem
        btnSobre.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        btnSobre.vrPosition.setY(btnSobre.vrPosition.getY()+700);

        btnAjuda = this.createSprite(R.mipmap.btn_ajuda, 1, 1);
        btnAjuda.setScreenPercent(20, 10); //Tamanho da imagem
        btnAjuda.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        btnAjuda.vrPosition.setY(btnAjuda.vrPosition.getY()+500);

        //BOTÃO PARA CHAMAR A CENA MENU
        btnNext = this.createSprite(R.mipmap.btn_next, 1, 1);
        btnNext.setScreenPercent(20, 10); //Tamanho da imagem
        btnNext.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        btnNext.vrPosition.setY(AGScreenManager.iScreenHeight/10);
    }

    @Override
    public void restart() { //Volta a aplicação para onde parou quando foi chamado o método stop

    }

    @Override
    public void stop() { //Para a aplicação enquanto a aplicação passa para segundo plano

    }

    @Override
    public void loop() {
        if(AGInputManager.vrTouchEvents.screenClicked()){ //Quando receber o clique do usuário...
            if(btnNext.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                this.vrGameManager.setCurrentScene(1); //...a cena CenaMenu é chamada
                return;
            }
        }
        if(AGInputManager.vrTouchEvents.screenClicked()){ //Quando receber o clique do usuário...
            if(btnSobre.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                this.vrGameManager.setCurrentScene(5); //...a cena CenaMenu é chamada
                return;
            }
        }
        if(AGInputManager.vrTouchEvents.screenClicked()){ //Quando receber o clique do usuário...
            if(btnAjuda.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                this.vrGameManager.setCurrentScene(6); //...a cena CenaMenu é chamada
                return;
            }
        }
    }
}
