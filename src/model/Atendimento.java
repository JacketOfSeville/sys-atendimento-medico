package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Atendimento {
  private LocalDate data;
  private String descricao;
  
  public String getDescricao() {
    return descricao;
  }
  
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Atendimento(LocalDate data, String descricao) {
    this.data = data;
    this.descricao = descricao;
  }

  @Override
  public String toString(){
    DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern ("dd/MM/yyyy");
    String data = formatoBr.format(this.data);
    String retorno = "Data: "+data;
    retorno += "\nInformações: "+descricao;
    return retorno;
  }
}