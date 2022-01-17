let champ = []
var indexs = 1
var indexa = 1

$.getJSON('http://ddragon.leagueoflegends.com/cdn/12.1.1/data/en_US/champion.json', function(data){
    let allChamp = []
    let allSkill = []
    let allSkin = []
    champ = Object.keys(data.data)
    champ.forEach(element => {
        $.getJSON('http://ddragon.leagueoflegends.com/cdn/12.1.1/data/en_US/champion/'+element+'.json', function(data) {
            let name = Object.keys(data.data)
            let a = {
                "name": name[0],
                "title": data.data[element].title,
                "role": data.data[element].tags[0],
                "difficulty": check(data.data[element].info.difficulty),
                "lore": data.data[element].blurb
                // "skins": setSkin(data.data[element].skins),
                // "skills": setSkill(data.data[element].spells, data.data[element].passive)
            }
            allChamp.push(a)
            let b = setSkin(data.data[element].skins)
            b.forEach(c =>{
                allSkin.push(c)
            })
            let d = setSkill(data.data[element].spells, data.data[element].passive)
            d.forEach(c =>{
                allSkill.push(c)
            })
        });
    })
    console.log(allChamp)
    console.log(allSkill)
    console.log(allSkin)
})

function check(diff){
    if(diff > 3){
        return "HARD"
    }else if(diff > 1){
        return "MODERATE"
    }else{
        return "EASY"
    }
}

function setSkill(skills, passive){
    let a = []
    let b = ["Q",'W','E','R']
    let ins = 0
    a.push({
        "champion_idi": indexs,
        "description": passive.description,
        "name": passive.name,
        "slot": "PASSIVE"
    })
    skills.forEach(element => {
        a.push({
            "champion_idi": indexs,
            "description": element.description,
            "name": element.name,
            "slot": b[ins++]
        })
    });
    indexs++
    return a
}

function setSkin(skins){
    let a = []
    skins.forEach(element => {
        a.push({
            "champion_idi": indexa,
            "name": element.name,
            "chromas": element.chromas
        })
    });
    indexa++
    return a
}