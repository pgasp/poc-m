// Deploy from now then mutate a document in `travel-sample`
function OnUpdate(doc, meta) {
    // ignore information we don't care about
   if (doc.metaDoc == null||doc.metaDoc.docType==null) return;

    var numdoscontgft = doc.numdoscontgft;  // get Num contentieux - a true variable as a N1QL parameter
    var typeDoc="CONTENTIEUXCONTRAT";
   var result = N1QL("SELECT meta().id as id from  `poc-mgen-2021-001` WHERE metaDoc.docType = "+typeDoc+" AND numdoscontgf="+doc.numdoscontgft);
   for (var val of result) {
    var contentieux= cachedigital[val.id];
    contentieux.codnatcont=doc.codnatcont;
    contentieux.datcredoscontgft=doc.datcredoscontgft;
    contentieux.metaDoc.lastUpdateBy="Event_MergeDossierContentieux";
    contentieux.metaDoc.lastUpdatedate=yyyymmdd();
    cachedigital[val.id]=contentieux;
     log("Update of contentieux: " + val.id + ", contentieux: "+doc.numdoscontgft+"with value codnatcont:"+doc.codnatcont+" datcredoscontgft:"+doc.datcredoscontgft);
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