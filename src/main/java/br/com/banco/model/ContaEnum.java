package br.com.banco.model;

public enum ContaEnum {
    FISICA(10, 5, "FISICA"),
    JURIDICA(10, 5, "JURIDICA"),
    GOVERNAMENTAL(20, 5, "GOVERNAMENTAL");

    private double taxa;
    private Integer qtSaque;
    private String desc;

    ContaEnum(double taxa, Integer qtSaque, String desc) {
        this.taxa = taxa;
        this.qtSaque = qtSaque;
        this.desc = desc;
    }

    public double getTaxa() {
        return taxa;
    }

    public Integer getQtSaque() {
        return qtSaque;
    }

    public String getDesc() {
        return desc;
    }

    public static ContaEnum getByTipoConta(String tipo) {
        if (ContaEnum.FISICA.getDesc().equalsIgnoreCase(tipo)) {
            return ContaEnum.FISICA;
        } else if (ContaEnum.JURIDICA.getDesc().equalsIgnoreCase(tipo)) {
            return ContaEnum.JURIDICA;
        } else if (ContaEnum.GOVERNAMENTAL.getDesc().equalsIgnoreCase(tipo)) {
            return ContaEnum.GOVERNAMENTAL;
        }
        return null;
    }
}