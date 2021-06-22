function OnUpdate(doc, meta) {

    if (doc.metaDoc == null||doc.metaDoc.docType==null) return;
    // calcul nouveau Id tech avec version date du jour
    var newDocID=meta.id+"::"+yyyymmddhhmmssms();
    doc.metaDoc.lastUpdateBy = "EvtArchivage";
    doc.metaDoc.archivedate = yyyymmdd();
    cachedigitalArchive[newDocID]=doc;
}

function yyyymmdd() {
    var now = new Date();
    var y = now.getFullYear();
    var m = now.getMonth() + 1;
    var d = now.getDate();
    var minutes=now.getMinutes();
    var hours=now.getHours();
    var seconds=now.getSeconds();
    var millisecondes=now.getMilliseconds();
    var mm = m < 10 ? '0' + m : m;
    var dd = d < 10 ? '0' + d : d;
    return '' + y + mm + dd;
}
function yyyymmddhhmmssms() {
    var now = new Date();
    var y = now.getFullYear();
    var m = now.getMonth() + 1;
    var d = now.getDate();
    var minutes=now.getMinutes();
    var hours=now.getHours();
    var seconds=now.getSeconds();
    var millisecondes=now.getMilliseconds();
    var mm = m < 10 ? '0' + m : m;
    var dd = d < 10 ? '0' + d : d;
    return '' + y + mm + dd+hours+minutes+seconds+millisecondes;
}