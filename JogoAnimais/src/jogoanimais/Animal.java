/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoanimais;

public class Animal {

    private String nomeAnimal;
    
    public Animal() {
    }

    public Animal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    @Override
    public String toString() {
        return nomeAnimal;
    }
}
