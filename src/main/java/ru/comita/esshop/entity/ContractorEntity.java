package ru.comita.esshop.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContractorEntity {

    @SerializedName("contractorName")
    @Expose
    private String contractorName;
    @SerializedName("contractorLogin")
    @Expose
    private String contractorLogin;
    @SerializedName("contractorPassword")
    @Expose
    private String contractorPassword;

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {

        this.contractorName = contractorName;
    }

    public String getContractorLogin() {
        return contractorLogin;
    }

    public void setContractorLogin(String contractorLogin) {
        this.contractorLogin = contractorLogin;
    }

    public String getContractorPassword() {
        return contractorPassword;
    }

    public void setContractorPassword(String contractorPassword) {
        this.contractorPassword = contractorPassword;
    }

    @Override
    public String toString() {
        return "ContractorEntity{" +
                "contractorName='" + contractorName + '\'' +
                ", contractorLogin='" + contractorLogin + '\'' +
                ", contractorPassword='" + contractorPassword + '\'' +
                '}';
    }
}