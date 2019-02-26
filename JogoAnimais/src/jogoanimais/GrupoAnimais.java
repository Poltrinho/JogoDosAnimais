/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoanimais;

import java.util.ArrayList;

/**
 *
 * @author Poltrinho
 */
public class GrupoAnimais {
    private String nomeGrupo;
    
    private final ArrayList<Animal> listAnimais = new ArrayList();

    public GrupoAnimais(String nomeGrupo, Animal animal) 
    {
        this.nomeGrupo = nomeGrupo;
        this.listAnimais.add(animal); 
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public ArrayList<Animal> getListAnimais() {
        return listAnimais;
    }

    public void setAnimalList(Animal animal) {
        this.listAnimais.add(animal);
    }
}
