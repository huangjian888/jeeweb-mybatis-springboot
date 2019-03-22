package com.company.manerger.sys.common.queue.router;


public class RouterHelper {
    private static RouterHelper mInstance = null;
    private AbsRouter messageRouter = new MessageRouter();

    public static RouterHelper getInstance(){
        if(mInstance == null){
            synchronized (RouterHelper.class){
                if(mInstance == null){
                    mInstance = new RouterHelper();
                }
            }
        }
        return mInstance;
    }

    public AbsRouter getMessageRouter(){
        return messageRouter;
    }

}
