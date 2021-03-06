package br.com.hellmets.motocerol;

import br.com.hellmets.motocerol.AndGraph.AGGameManager;
import br.com.hellmets.motocerol.AndGraph.AGInputManager;
import br.com.hellmets.motocerol.AndGraph.AGScene;
import br.com.hellmets.motocerol.AndGraph.AGScreenManager;
import br.com.hellmets.motocerol.AndGraph.AGSprite;

/**
 * Created by Daniel Rodrigues on 14/12/2017.
 */

public class AjudaJogo extends AGScene {

    AGSprite btnGoBack = null;
    AGSprite imgAjudaFundo = null;

    AjudaJogo(AGGameManager manager){
        super(manager);
    }

    @Override
    public void init() { //Chamado toda vez que a cena Abertura é mostrada (iniciada). Aloca recursos
        setSceneBackgroundColor(0,1,1);

        //IMAGEM DERROTADO
        imgAjudaFundo = this.createSprite(R.mipmap.img_ajuda_fundo, 1, 1);
        imgAjudaFundo.setScreenPercent(100, 100); //Tamanho da imagem
        imgAjudaFundo.vrPosition.setXY (AGScreenManager.iScreenWidth/2, AGScreenManager.iScreenHeight/2);

        //BOTÃO PARA CHAMAR A CENA MENU
        btnGoBack = this.createSprite(R.mipmap.btn_goback, 1, 1);
        btnGoBack.setScreenPercent(20, 10); //Tamanho da imagem
        btnGoBack.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        btnGoBack.vrPosition.setY(btnGoBack.vrPosition.getY()+100);
    }

    @Override
    public void restart() { //Volta a aplicação para onde parou quando foi chamado o método stop

    }

    @Override
    public void stop() { //Para a aplicação enquanto a aplicação passa para segundo plano

    }

    @Override
    public void loop() {
        if (AGInputManager.vrTouchEvents.screenClicked()) { //Verifica se a tela foi tocada
            if (btnGoBack.collide(AGInputManager.vrTouchEvents.getLastPosition())) { //verifica se o toque foi dentro dos limites da imagem do botao
                this.vrGameManager.setCurrentScene(0);
                return;
            }
        }
    }
}
