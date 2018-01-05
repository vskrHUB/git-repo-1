trigger AccountTrigger on Account (before insert,before update) {

    for(Account act : Trigger.new){
        act.industry='Agriculture';
    }

}