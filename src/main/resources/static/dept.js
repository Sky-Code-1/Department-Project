function onToggleButtonClick(){
    let header = document.querySelector(".js-header-div");
    let headerClassList = header.classList;
    let checkClassList = false;
    for(let i = 0; i < headerClassList.length; i++){
        if(headerClassList[i] === "header-div-two"){
            checkClassList = true;
            break;
        }
    }
    if(checkClassList){
        header.classList.remove("header-div-two");
        document.querySelector("body").classList.remove("body-two");
        document.querySelector(".js-sidebar-div").classList.add("sidebar-div-two");
    }
    else{
        header.classList.add("header-div-two");
        document.querySelector(".js-sidebar-div").classList.remove("sidebar-div-two");
        document.querySelector("body").classList.add("body-two");
    }

}