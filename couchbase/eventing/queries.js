Update `poc-mgen-2021-001` UNSET domBank where metaDoc.docType = "CONTRATINDIVSANTE"
select * from `poc-mgen-2021-001` where metaDoc.docType = "CONTRATINDIVSANTE" and idCtr="10RC0005036666"
select distinct(NOIDE) from `poc-mgen-2021-001` where metaDoc.docType = "USAGEPRESTATION" and NOCTR="10RC0005036666"
[
    {
      "NOIDE": "0104981620"
    },
    {
      "NOIDE": "0104981621"
    },
    {
      "NOIDE": "0106280491"
    },
    {
      "NOIDE": "0107299679"
    }
  ]

  SELECT contrat.domBank,
       domBankCtr.*
FROM `poc-mgen-2021-001` AS contrat
UNNEST contrat.domBank AS domBankCtr
    JOIN `poc-mgen-2021-001` AS domiciliationBank ON domBankCtr.idDomBq=domiciliationBank.idDomBq

WHERE contrat.metaDoc.docType="CONTRATINDIVSANTE" and domiciliationBank.metaDoc.docType="DOMICILIATIONBANCAIRE"