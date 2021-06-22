
function OnUpdate(doc, meta) {
    // ignore information we don't care about
    if(doc.metaDoc == null) return;
    if (doc.metaDoc.docType !== 'DOSSIERCONTENTIEUX') return;
    var numdoscontgft = doc.numdoscontgft;  // get Num contentieux - a true variable as a N1QL parameter
   var result = SELECT meta().id as id from  `poc-mgen-2021-001` WHERE metaDoc.docType = "CONTENTIEUXCONTRAT" AND numdoscontgft = $numdoscontgft;
   for (var val of result) {
    var contentieux= cachedigital[val.id];
    contentieux.codnatcont=doc.codnatcont;
    contentieux.datcredoscontgft=doc.datcredoscontgft;
    contentieux.metaDoc.lastUpdateBy="EvtMgDosCont";
    contentieux.metaDoc.lastUpdatedate=yyyymmdd();
    cachedigital[val.id]=contentieux;
     log("Update of contentieux: " + val.id + ", contentieux: "+doc.numdoscontgft+"with value codnatcont:"+doc.codnatcont+" datcredoscontgft:"+doc.datcredoscontgft);
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
}