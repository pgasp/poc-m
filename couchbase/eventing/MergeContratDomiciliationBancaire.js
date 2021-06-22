function OnUpdate(doc, meta) {

    if (doc.metaDoc == null||doc.metaDoc.docType==null) return;
    if (doc.metaDoc.docType.startsWith("USAGE") == true) {
        var idCtr = doc.NOCTR;  // get Num contentieux - a true variable as a N1QL parameter
        var keyCtr = "CONTRATINDIVSANTE::" + idCtr;
        var contrat = cachedigital[keyCtr];
        if (contrat != null) {
            contrat = addDomicilisation(keyCtr, contrat, doc);
        }
    }
}
function yyyymmdd() {
    var now = new Date();
    var y = now.getFullYear();
    var m = now.getMonth() + 1;
    var d = now.getDate();
    var mm = m < 10 ? '0' + m : m;
    var dd = d < 10 ? '0' + d : d;
    return '' + y + mm + dd;
}
function addDomicilisation(keyCtr, contrat, doc) {
    let domicilisations = contrat.domBank;
    let dom = createDomiciliation(doc)
   
    if (domicilisations == null) {
        domicilisations = [dom];
       
    } else {

        addItem(domicilisations, dom)

    }
    
        contrat.domBank = domicilisations;
        contrat.metaDoc.lastUpdateBy = "Evt_MgCtrDomBank";
        contrat.metaDoc.lastUpdatedate = yyyymmdd();
        log(" Modify Contrat" + keyCtr + "Dom Bank" + dom.idDom + " Type Source" + dom.type);
        cachedigital[keyCtr] = contrat;
 
    return contrat;
}
function createDomiciliation(doc) {
    return { "idDom": doc.NOIDE,  "type": doc.metaDoc.docType }

}

function addItem(array, item) { 
    const i = array.findIndex(_item => _item.idDom === item.idDom );
    if (i > -1) array[i] = item; // (2)
    else array.push(item);
}

function OnDelete(meta, options) {
}