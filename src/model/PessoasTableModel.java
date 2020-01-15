package model;

import control.PessoaFisica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PessoasTableModel extends AbstractTableModel {

    private List<PessoaFisica> pessoas;
    private String[] colunas = new String[]{"Nome", "CPF", "Data Nasc"};
//        private int id;
//    private String nome;
//    private String CPF;
//    private String dataNascimento;
//    private String Sexo;
//    private Escolaridade_Situacao escolaridade;
//    private Profissao profissao;
    
    public PessoasTableModel(List<PessoaFisica> pessoas) {
        this.pessoas = pessoas;
    }

    public PessoasTableModel() {
        this.pessoas = new ArrayList<PessoaFisica>();
    }

    public int getRowCount() {
        return pessoas.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public void setValueAt(PessoaFisica aValue, int rowIndex) {
        PessoaFisica pessoa = pessoas.get(rowIndex);
        
        pessoa.setNome(aValue.getNome());
        pessoa.setCPF(aValue.getCPF());
        pessoa.setDataNascimento(aValue.getDataNascimento());

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        PessoaFisica pessoa = pessoas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                pessoa.setNome(aValue.toString());
            case 1:
                pessoa.setCPF(aValue.toString());
            case 2:
                pessoa.setDataNascimento(aValue.toString());

            default:
                System.err.println("Índice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        PessoaFisica pessoaSelecionada = pessoas.get(rowIndex);
        String valueObject = null;
        switch (columnIndex) {
            case 0:
                valueObject = pessoaSelecionada.getNome();
                break;
            case 1:
                valueObject = pessoaSelecionada.getCPF();
                break;
            case 2:
                valueObject = pessoaSelecionada.getDataNascimento();
                break;
            default:
                System.err.println("Índice inválido para propriedade do bean Usuario.class");
        }

        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public PessoaFisica getPessoa(int indiceLinha) {
        return pessoas.get(indiceLinha);
    }

    public void addPessoa(PessoaFisica u) {
        pessoas.add(u);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removePessoa(int indiceLinha) {
        pessoas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDePessoas(List<PessoaFisica> novoasPessoas) {

        int tamanhoAntigo = getRowCount();
        pessoas.addAll(novoasPessoas);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void limpar() {
        pessoas.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return pessoas.isEmpty();
    }

}
