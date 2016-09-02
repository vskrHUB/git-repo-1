trigger HelloWorldTriggerTest on Account (before insert) {

    for(Account d : Trigger.New) {

        d.Description = 'Account Description for this HelloWorldTriggerTest';

    }  

}