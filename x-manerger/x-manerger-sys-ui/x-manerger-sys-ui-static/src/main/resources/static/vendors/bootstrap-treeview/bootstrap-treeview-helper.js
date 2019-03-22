/** 
 * @desc 将N级外来数据转化为bootstrap treeview可填充的数据 
 * @param {Object} resp 需要被处理的数组 
 * @param {Array} structure such as [{text: "menuGroupName", nodes: "menu"},{text: "menuName", nodes: "function"},{text: "functionName", nodes: "..."},...] 
 *                              但需要注意，structure内的元素必须是按层级从左向右依次下降的。 
 */
loopLevel=0;  
function obj2treeview(resp,structure){  
    var nodeArray = new Array();  
    var i = 0;  
        for(i= 0;i<resp.length;i++){  
            var treeViewNodeObj;  
            var textStr = structure[loopLevel].text;  
            var nodeStr = structure[loopLevel].nodes;  
          
            var subNode;  
            if(resp[i][nodeStr] != undefined){  
                loopLevel++;  
                subNode = obj2treeview(resp[i][nodeStr],structure);  
                loopLevel--;  
            }  
              
            if(subNode != undefined){  
                treeViewNodeObj = {  
                    text: resp[i][textStr],  
                    nodes: subNode  
                };  
            }else{  
                treeViewNodeObj = {  
                    text: resp[i][textStr]  
                };  
            }  
            nodeArray.push(treeViewNodeObj);  
        }  
        return nodeArray  
}  