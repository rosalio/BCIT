
D2L.Control.CustomSelector=D2L.Control.extend({Construct:function(){arguments.callee.$.Construct.call(this);this.m_allowMultiple=true;this.m_addButton=null;this.m_addButtons=[];this.m_addOnClick=null;this.m_reorderButton=null;this.m_isEnabled=true;this.m_numActiveItems=0;this.m_statusInputs=[];this.m_hasDeleteAll=false;this.m_integrationComplete=false;this.m_emptyText="";this.m_notEmptyText="";this.m_deleteAllSpan=null;this.m_deleteAllImg=null;this.m_emptyTextCell=null;this.m_reorderText="";this.m_restoreTermName=
"Framework.CustomSelector.altRestore";this.m_removeTermName="Framework.CustomSelector.altRemove";this.m_name="";this.m_isDisplayed=true;this.OnAddItem=new D2L.EventHandler;this.OnDeleteItem=new D2L.EventHandler;this.OnRestoreItem=new D2L.EventHandler},IntegrateControlMin:function(deserializer){arguments.callee.$.IntegrateControlMin.call(this,deserializer);var isEnabled=deserializer.GetBoolean();if(!isEnabled)this.SetIsEnabled(false);this.m_allowMultiple=deserializer.GetBoolean();this.m_hasDeleteAll=
deserializer.GetBoolean();this.m_emptyText=deserializer.GetMember();this.m_notEmptyText=deserializer.GetMember();this.m_reorderText=deserializer.GetMember();this.m_restoreTermName=deserializer.GetMember();this.m_removeTermName=deserializer.GetMember();var items=deserializer.GetObjectArrayMin(D2L.Control.CustomSelectorItem);this.m_name=deserializer.GetMember();this.m_isDisplayed=deserializer.GetBoolean();var addButtonCount=deserializer.GetMember();if(this.m_name.length===0)this.m_name=this.GetMappedId();
this.IChildrenDomNode=this.GetDomNode().firstChild;D2L.Util.Aria.SetRole(this.GetDomNode(),"presentation");if(addButtonCount>0)for(var i=0;i<addButtonCount;i++){var addButton=UI.GetControl(this.GetMappedId()+"_b"+i);if(addButton){this.m_addButtons.push(addButton);if(i==0)this.m_addButton=addButton}}this.m_reorderButton=UI.GetControl(this.GetMappedId()+"_reo");if(this.m_hasDeleteAll){this.m_deleteAllSpan=UI.GetById(this.GetMappedId()+"_das");this.m_deleteAllImg=this.m_deleteAllSpan.childNodes[1].firstChild}var rowOffset=
0;if(this.m_addButtons&&this.m_addButtons.length>0||this.m_hasDeleteAll||this.m_reorderButton)rowOffset++;if(this.m_emptyText.length>0||this.m_notEmptyText.length>0){this.m_emptyTextCell=this.GetDomNode().rows[rowOffset].cells[0];rowOffset++}for(var i=0;i<items.length;i++){items[i].IntegrateChild(this,this.GetDomNode().rows[i+rowOffset]);if(!items[i].IsDeleted())this.m_numActiveItems++}if(!this.AllowMultiple()&&this.Children().length>0)this.HideAddButtons();this.ReorderItems();this.m_integrationComplete=
true},AppendChild:function(child){if(this.AllowMultiple()||this.m_numActiveItems===0){var existing=this.GetItem(child.GetKey());if(existing){if(child.IsDeleted()&&!existing.IsDeleted())this.DeleteItem(existing);else if(!child.IsDeleted()&&existing.IsDeleted())this.RestoreItem(existing);return existing}child=arguments.callee.$.AppendChild.call(this,child);this.OnAddItem.Trigger(child);if(!child.IsDeleted())this.m_numActiveItems++;else this.DeleteItem(child);if(!this.AllowMultiple()&&this.m_numActiveItems>
0)this.HideAddButtons();if(this.AllowMultiple()&&this.m_reorderButton&&this.m_numActiveItems>0)this.m_reorderButton.SetIsEnabled(true);if(this.m_hasDeleteAll&&this.m_deleteAllSpan)this.m_deleteAllSpan.style.display="inline";if(this.Children().length==1&&this.m_emptyTextCell)this.m_emptyTextCell.innerHTML=this.m_notEmptyText;this.SetItemOrder();if(this.m_integrationComplete){var e=new D2L.ChangeEvent(child.GetDomNode());e.hasChangeBeenShown=true;e.Bubble()}return child}return null},RemoveChild:function(child,
doRemove){if(child&&this.IsEnabled()){var p=child.GetDomNode().parentNode;if(!this.AllowMultiple()){if(!child.IsDeleted())this.m_numActiveItems--;this.ShowAddButtons();if(child.IsNew())this.SetItemStatus(child.GetKey(),"");else this.SetItemStatus(child.GetKey(),"existingDeleted");if(child.m_dataInput!==null)this.GetDomNode().parentNode.appendChild(child.m_dataInput.parentNode.removeChild(child.m_dataInput));var width=this.GetDomNode().offsetWidth;arguments.callee.$.RemoveChild.call(this,child);this.GetDomNode().style.width=
width+"px";this.OnDeleteItem.Trigger(child)}else if(!doRemove){child.Delete();this.OnDeleteItem.Trigger(child)}else arguments.callee.$.RemoveChild.call(this,child);if(this.AllowMultiple()&&this.m_reorderButton&&this.m_numActiveItems<1)this.m_reorderButton.SetIsDisabled(true);if(this.m_numActiveItems===0&&this.m_emptyTextCell)this.m_emptyTextCell.innerHTML=this.m_emptyText;this.SetItemOrder();var e=new D2L.ChangeEvent(p);e.hasChangeBeenShown=this.AllowMultiple();e.Bubble()}else child=null;return child},
Add:function(key,contents){this.AppendChild(new D2L.Control.CustomSelectorItem(key,contents))},AddItem:function(item){return this.AppendChild(item)},AllowMultiple:function(){return this.m_allowMultiple},DeleteAll:function(){for(var i=0;i<this.Children().length;i++)this.DeleteItem(this.Children()[i])},DeleteItem:function(item){return this.RemoveChild(item)},Disable:function(){this.m_isEnabled=false;if(this.GetDomNode())this.GetDomNode().className="dcs dcs_d";this.DisableAddButtons();if(this.m_reorderButton)this.m_reorderButton.SetIsEnabled(false);
if(this.m_hasDeleteAll&&this.m_deleteAllImg)D2L.Images.ImageTerm.Assign("Shared.Main.actRemoveDisabled",this.m_deleteAllImg);for(var i=0;i<this.Children().length;i++){this.Children()[i].Render_Delete();this.Children()[i].Render_Actions();this.Children()[i].Render_Info()}},DisableAddButtons:function(){if(this.m_addButtons&&this.m_addButtons.length>0)for(var i=0;i<this.m_addButtons.length;i++)this.m_addButtons[i].SetIsEnabled(false)},Enable:function(){this.m_isEnabled=true;if(this.GetDomNode())this.GetDomNode().className=
"dcs";this.EnableAddButtons();if(this.m_reorderButton&&this.m_numActiveItems>0&&this.AllowMultiple())this.m_reorderButton.SetIsEnabled(true);if(this.m_hasDeleteAll&&this.m_deleteAllImg)D2L.Images.ImageTerm.Assign("Shared.Main.actRemove",this.m_deleteAllImg);for(var i=0;i<this.Children().length;i++){this.Children()[i].Render_Delete();this.Children()[i].Render_Actions();this.Children()[i].Render_Info()}},EnableAddButtons:function(){if(this.m_addButtons&&this.m_addButtons.length>0)for(var i=0;i<this.m_addButtons.length;i++)this.m_addButtons[i].SetIsEnabled(true)},
Focus:function(){if(!this.AllowMultiple()&&this.GetNumItems()>0)this.Children()[0].Focus();else if(this.m_addButtons&&this.m_addButtons.length>0)this.m_addButtons[0].Focus()},GetItem:function(key){for(var i=0;i<this.Children().length;i++)if(this.Children()[i].GetKey()==key)return this.Children()[i];return null},GetNumItems:function(){var count=0;if(this.AllowMultiple())return this.Children().length;else count=this.m_numActiveItems;return count},GetNumActiveItems:function(){var count=0;var children=
this.Children();for(var i=0;i<children.length;i++)if(!children[i].IsDeleted())count++;return count},GetState:function(serializer){serializer.AddMember("IsEnabled",this.IsEnabled());serializer.AddMember("Items",this.Children())},HideAddButtons:function(){if(this.m_addButtons&&this.m_addButtons.length>0)for(var i=0;i<this.m_addButtons.length;i++)this.m_addButtons[i].Hide()},IsDisplayed:function(){return this.m_isDisplayed},IsEnabled:function(){return this.m_isEnabled},ToggleDeleteItem:function(item){if(this.IsEnabled())if(item.IsDeleted())this.RestoreItem(item);
else this.DeleteItem(item)},Reorder:function(){var d=new D2L.Dialog("reorderDialog");d.SetTitle(new D2L.LP.Text.LangTerm("FrameworkWebPages.ReorderDialog.ttlReorderOptions"));d.AddButton(D2L.Control.Button.Type.Cancel);d.AddCustomButton(new D2L.LP.Text.LangTerm("Conditions.Main.btnApply"),D2L.Dialog.ButtonPosition.Right,D2L.Dialog.ResponseType.Positive);d.SetIsResizable(false);d.SetSize(400,230);d.SetSrc("/d2l/common/dialogs/reorder/reorder.d2l","SrcCallback");var itemsToReorder=new Array;for(var i=
0;i<this.Children().length;i++)itemsToReorder[i]=this.Children()[i];if(itemsToReorder.length>0){var sorter=function(item1,item2){return item1.GetData("order")-item2.GetData("order")};itemsToReorder.sort(sorter);var encoder=new d2l_Encoder("#","|",":","-");for(var i=0;i<itemsToReorder.length;i++){var data=new Array;data[0]=itemsToReorder[i].GetKey();data[1]=itemsToReorder[i].GetDomNode().firstChild.innerHTML;encoder.AddRow(data)}d.SetSrcParam("reorderItems",encoder.Serialize());var me=this;var args=
arguments;var ReorderCallback=function(response){if(response.GetType()==D2L.Dialog.ResponseType.Positive){var responseData=response.GetData("newOrder");var orders=encoder.Deserialize(responseData);for(var i=0;i<orders.length;i++)if(orders[i][0]&&orders[i][1]){var item=me.GetItem(orders[i][0]);if(item)item.SetData("order",orders[i][1],true)}me.ReorderItems()}response.GetDialog().Close()};d.SetCallback(ReorderCallback);d.Open()}},ReorderItems:function(){var reorderList=new Array;for(var j=0;j<this.Children().length;j++)if(this.Children()[j].GetData("order"))reorderList[j]=
this.Children()[j];var sorter=function(item1,item2){return item1.GetData("order")-item2.GetData("order")};reorderList.sort(sorter);var toPosition=0;for(i in reorderList)reorderList[i].m_parent.GetDomNode().firstChild.appendChild(reorderList[i].GetDomNode());this.SetItemOrder()},SetAddOnClick:function(onClick){if(onClick){this.m_addOnClick=onClick;if(this.m_addButton){var me=this;this.AttachObject(this.m_addButton.GetDomNode(),"onclick",function(){if(me.m_isEnabled)return me.m_addOnClick.call(me);
else return false})}}},SetIsDisplayed:function(isDisplayed){this.m_isDisplayed=isDisplayed;if(this.IsRendered())this.GetDomNode().style.display=isDisplayed?"block":"none"},SetIsEnabled:function(isEnabled){if(isEnabled)this.Enable();else this.Disable()},SetItemOrder:function(){for(var j=0;j<this.Children().length;j++)this.Children()[j].SetData("order",this.Children()[j].GetDomNode().rowIndex-1,false)},ShowAddButtons:function(){if(this.m_addButtons&&this.m_addButtons.length>0)for(var i=0;i<this.m_addButtons.length;i++)this.m_addButtons[i].Show()},
RestoreItem:function(item){if(this.IsEnabled()){if(item.IsDeleted()){this.m_numActiveItems++;this.OnRestoreItem.Trigger(item)}if(!this.AllowMultiple()){if(item.GetDomNode())if(UI.GetBrowserInfo().Type==D2L.UI.BrowserType.IE)item.GetDomNode().style.display="inline";else item.GetDomNode().style.display="table-row";if(this.m_addButtons&&this.m_addButtons.length>0)for(var i=0;i<this.m_addButtons.length;i++)this.m_addButtons[i].style.display="none"}item.Restore()}},SetAllowMultiple:function(allowMultiple){this.m_allowMultiple=
allowMultiple;if(!allowMultiple&&this.Children().length>0)this.HideAddButtons();else if(allowMultiple)this.ShowAddButtons()},SetIsEnabled:function(isEnabled){if(isEnabled)this.Enable();else this.Disable()},SetItemStatus:function(key,status){if(!this.m_statusInputs[key]&&status.length>0){this.m_statusInputs[key]=document.createElement("input");this.m_statusInputs[key].type="hidden";this.m_statusInputs[key].value=key;this.m_statusInputs[key].name=this.m_name+"_"+status;this.GetDomNode().parentNode.appendChild(this.m_statusInputs[key])}else if(this.m_statusInputs[key]&&
status.length===0){D2L.Util.Dom.Purge(this.m_statusInputs[key]);this.m_statusInputs[key].parentNode.removeChild(this.m_statusInputs[key]);this.m_statusInputs[key]=null}else this.m_statusInputs[key].name=this.m_name+"_"+status}});
D2L.Control.CustomSelectorItem=D2L.Control.extend({Construct:function(key,contents){if(key===undefined)key="";if(contents===undefined)contents="";arguments.callee.$.Construct.call(this);this.m_actions=[];this.m_actionsCell=null;this.m_deleteIsEnabled=true;this.m_infoText="";this.m_isDeleted=false;this.m_isModified=false;this.m_isNew=true;this.m_key=key;this.m_canDelete=true;this.m_originalIsDeleted=false;this.m_data=new D2L.Util.Dictionary;this.m_dataInput=null;this.m_contents=contents;this.m_deleteAnchor=
null;this.m_deleteCell=null;this.m_deleteCellVAlign=null;this.m_deleteIcon=null;this.m_infoAnchor=null;this.m_infoCell=null;this.m_infoIcon=null;this.m_subject="";this.m_order=0;var me=this;Nav.OnNavigate.RegisterMethod(function(){if(me.IsRendered())me.m_dataInput.value=D2L.Serialization.JsonSerializer.Serialize(me.m_data)})},DeserializeMin:function(deserializer){this.m_deleteIsEnabled=deserializer.GetBoolean();this.m_infoText=deserializer.GetMember();this.m_isDeleted=deserializer.GetBoolean();this.m_isModified=
deserializer.GetBoolean();this.m_isNew=deserializer.GetBoolean();this.m_key=deserializer.GetMember();this.m_canDelete=deserializer.GetBoolean();this.m_originalIsDeleted=deserializer.GetBoolean();this.m_subject=deserializer.GetMember();this.m_order=deserializer.GetMember();this.m_actions=deserializer.GetObjectArrayMin(D2L.Control.CustomSelectorItemAction)},IntegrateChild:function(parent,domNode){arguments.callee.$.IntegrateChild.call(this,parent,domNode);var item=this;this.IChildrenDomNode=this.GetDomNode().cells[0];
this.m_actionsCell=this.GetDomNode().cells[1];this.m_deleteCell=this.GetDomNode().cells[2];this.m_infoCell=this.GetDomNode().cells[3];this.m_dataInput=this.m_actionsCell.childNodes[this.m_actionsCell.childNodes.length-1];if(this.m_actions)for(var i=0;i<this.m_actions.length;i++)this.m_actions[i].Integrate(this,this.m_actionsCell.childNodes[i]);this.m_data=D2L.Serialization.JsonDeserializer.Deserialize(this.m_dataInput.value,D2L.Util.Dictionary);this.m_deleteAnchor=this.m_deleteCell.childNodes[0];
this.AttachObject(this.m_deleteAnchor,"onclick",function(){item.Parent().ToggleDeleteItem(item)});this.m_deleteIcon=this.m_deleteAnchor.firstChild;this.m_infoAnchor=this.m_infoCell.firstChild;this.AttachObject(this.m_infoAnchor,"onclick",function(){item.DisplayInfoText()});this.m_infoIcon=this.m_infoAnchor.firstChild;this.Render_Row();this.Render_Status();var content=this.GetData("name");if(content&&this.m_contents=="")this.SetContent(content)},BuildDom:function(){if(!this.IsRendered()){arguments.callee.$.BuildDom.call(this);
this.SetDomNode(this.Parent().GetDomNode().insertRow(-1));if(this.m_parent.AllowMultiple())this.GetDomNode().style.borderTop="1px solid #cccccc";else this.GetDomNode().style.borderTopStyle="none";var item=this;this.Render_Row();this.IChildrenDomNode=this.GetDomNode().insertCell(-1);this.IChildrenDomNode.className="dcs_c dcs_cf";if(!this.m_parent.AllowMultiple())this.IChildrenDomNode.style.borderTopStyle="none";this.SetContent(this.m_contents);if(this.m_parent.GetDomNode().style.width.length>0)this.IChildrenDomNode.style.width=
"100%";this.m_actionsCell=this.GetDomNode().insertCell(-1);this.m_actionsCell.className="dcs_c";this.m_actionsCell.style.paddingRight="0";this.m_actionsCell.style.whiteSpace="nowrap";if(!this.m_parent.AllowMultiple())this.m_actionsCell.style.borderTopStyle="none";for(var i=0;i<this.m_actions.length;i++)this.AppendChild(this.m_actions[i],this.m_actionsCell);this.m_dataInput=this.CreateElement("input");this.m_dataInput.type="hidden";this.m_dataInput.name=this.Parent().m_name+"_"+this.GetKey()+"_data";
this.m_actionsCell.appendChild(this.m_dataInput);this.m_deleteCell=this.GetDomNode().insertCell(-1);this.m_deleteCell.className="dcs_c";this.m_deleteCell.style.paddingRight="0";this.m_deleteCell.style.whiteSpace="nowrap";if(this.m_deleteCellVAlign!=null)this.m_deleteCell.style.verticalAlign=this.m_deleteCellVAlign;if(!this.m_parent.AllowMultiple())this.m_deleteCell.style.borderTopStyle="none";this.m_deleteAnchor=document.createElement("a");this.m_deleteAnchor.href="javascript://";this.AttachObject(this.m_deleteAnchor,
"onclick",function(){item.Parent().ToggleDeleteItem(item)});this.m_deleteIcon=document.createElement("img");this.m_deleteIcon.className="dcs_a";this.m_deleteAnchor.appendChild(this.m_deleteIcon);this.m_deleteCell.appendChild(this.m_deleteAnchor);this.Render_Delete();this.Render_Status();this.m_infoCell=this.GetDomNode().insertCell(-1);this.m_infoCell.className="dcs_c";this.m_infoCell.style.paddingLeft="0";if(!this.m_parent.AllowMultiple())this.m_infoCell.style.borderTopStyle="none";this.m_infoAnchor=
document.createElement("a");this.m_infoAnchor.href="javascript://";this.m_infoAnchor.style.display="none";this.AttachObject(this.m_infoAnchor,"onclick",function(){item.DisplayInfoText()});this.m_infoIcon=document.createElement("img");this.m_infoIcon.className="dcs_a";this.m_infoAnchor.appendChild(this.m_infoIcon);this.m_infoCell.appendChild(this.m_infoAnchor);this.Render_Info()}},AddAction:function(action){if(this.GetDomNode())this.AppendChild(action,this.m_actionsCell);this.m_actions.push(action)},
CanDelete:function(){return this.m_canDelete},Delete:function(){if(this.CanDelete()&&this.DeleteIsEnabled()&&!this.IsDeleted()){this.m_isDeleted=true;this.Render_Delete();this.Render_Row();this.Render_Status();this.Render_Actions()}},DeleteIsEnabled:function(){return this.m_deleteIsEnabled},DisableDelete:function(){this.m_deleteIsEnabled=false;this.Render_Delete();this.Render_Info()},DisplayInfoText:function(){if(this.Parent&&this.Parent().IsEnabled())UI.Info(this.m_infoText)},EnableDelete:function(){this.m_deleteIsEnabled=
true;this.Render_Delete();this.Render_Info()},Focus:function(){},GetData:function(dataKey){if(this.m_data.ContainsKey(dataKey))return this.m_data.Get(dataKey);return""},GetInfoText:function(){return this.m_infoText},GetKey:function(){return this.m_key},GetSubject:function(){return this.m_subject},IsDeleted:function(){return this.m_isDeleted},IsModified:function(){return this.m_isModified},IsNew:function(){return this.m_isNew},RemoveAction:function(action){this.RemoveChild(action)},RemoveData:function(dataKey){this.m_data.Remove(dataKey)},
Restore:function(){if(this.CanDelete()&&this.DeleteIsEnabled()&&this.IsDeleted()){this.m_isDeleted=false;this.Render_Delete();this.Render_Row();this.Render_Status();this.Render_Actions()}},Serialize:function(serializer){serializer.AddMember("CD",this.CanDelete());serializer.AddMember("ID",this.IsDeleted());serializer.AddMember("IM",this.IsModified());serializer.AddMember("IN",this.IsNew());serializer.AddMember("DE",this.DeleteIsEnabled());serializer.AddMember("T",this.GetInfoText());serializer.AddMember("K",
this.GetKey());serializer.AddMember("C",this.IChildrenDomNode.innerHTML);serializer.AddMember("OD",this.m_originalIsDeleted);serializer.AddMember("OR",this.GetData("order"));serializer.AddMember("A",this.m_actions);serializer.AddMember("D",this.m_data)},SetCanDelete:function(canDelete){this.m_canDelete=canDelete;this.Render_Delete()},SetContent:function(content){this.m_contents=content;if(content.length>0)if(this.IChildrenDomNode)this.IChildrenDomNode.innerHTML=content},SetData:function(key,val,isModification){if(val===
undefined||val===null)val="";if(isModification===undefined||isModification===null)isModification=false;if(this.m_data.ContainsKey(key))isModification=isModification&&this.m_data.Get()!=val;this.m_data.Add(key,val);if(isModification)this.SetIsModified(true)},SetSubject:function(subject){this.m_subject=subject;this.Render_Delete()},SetInfoText:function(infoText){this.m_infoText=infoText;this.Render_Info()},SetIsModified:function(isModified){var doRender=this.m_isModified!=isModified;this.m_isModified=
isModified;if(doRender){this.Render_Row();this.Render_Status()}},SetIsNew:function(isNew){this.m_isNew=isNew;this.Render_Row();this.Render_Status()},Render_Actions:function(){for(var i=0;i<this.m_actions.length;i++)this.m_actions[i].SetIsEnabled(this.Parent().IsEnabled()&&!this.IsDeleted())},Render_Delete:function(){if(this.m_deleteAnchor)if(this.CanDelete()){this.m_deleteAnchor.style.display="inline";var iconTerm;var iconClassName="dcs_a";var altTerm=null;if(this.IsDeleted()){altTerm=this.m_parent.m_restoreTermName;
if(this.m_parent.IsEnabled())iconTerm="Shared.Main.actAdd";else{iconTerm="Shared.Main.actAddDisabled";iconClassName+=" dcs_ad"}}else{altTerm=this.m_parent.m_removeTermName;if(this.m_parent.IsEnabled()&&this.DeleteIsEnabled())iconTerm="Shared.Main.actRemove";else{iconTerm="Shared.Main.actRemoveDisabled";iconClassName+=" dcs_ad"}}var term=new D2L.LP.Text.LangTerm(altTerm);term.SetSubject(this.m_subject);term.AssignText(this.m_deleteAnchor,"title");term.AssignText(this.m_deleteIcon,"alt");this.m_deleteIcon.className=
iconClassName;D2L.Images.ImageTerm.Assign(iconTerm,this.m_deleteIcon)}else this.m_deleteAnchor.style.display="none"},Render_Info:function(){if(this.m_infoIcon){if(this.m_infoAnchor)if(this.DeleteIsEnabled())this.m_infoAnchor.style.display="none";else this.m_infoAnchor.style.display="inline";if(this.m_parent.IsEnabled())D2L.Images.ImageTerm.Assign("Shared.Main.infInfo",this.m_infoIcon);else D2L.Images.ImageTerm.Assign("Shared.Main.infInfoDisabled",this.m_infoIcon)}},Render_Row:function(){if(this.IsRendered()){var className=
"";if(this.IsDeleted())className="dcs_r dcs_rd";else className="dcs_r";if(this.PreviousSibling()===null&&!this.Parent().m_hasDeleteAll&&this.Parent().m_addButton===null&&this.Parent().m_reorderButton===null)className+=" dcs_rnl";if(this.IsModified()||this.IsNew()||this.m_originalIsDeleted!=this.IsDeleted())className+=" D2LField_Modified";this.GetDomNode().className=className}},Render_Status:function(){if(this.Parent()){var status="";if(this.IsNew())if(this.IsDeleted())status="newDeleted";else status=
"new";else if(this.IsDeleted())status="existingDeleted";else if(this.IsModified())status="existingModified";else status="existing";this.Parent().SetItemStatus(this.GetKey(),status)}}});
D2L.Control.CustomSelectorItemAction=D2L.Control.extend({Construct:function(enabledSrc,disabledSrc,alt,onClick){arguments.callee.$.Construct.call(this);if(enabledSrc===undefined)enabledSrc="";if(disabledSrc===undefined)disabledSrc="";this.m_alt=D2L.LP.Text.IText.Normalize(alt,"D2L.Control.CustomSelectorItemAction","Constructor","alt");this.m_enabledSrc=enabledSrc;this.m_disabledSrc=disabledSrc;this.m_enabledInfo=null;this.m_disabledInfo=null;this.m_navInfo=null;this.m_img=null;this.m_isEnabled=true;
if(onClick!==undefined){this.m_navInfo=new D2L.NavInfo;this.m_navInfo.SetOnClick(onClick)}},DeserializeMin:function(deserializer){this.m_isEnabled=deserializer.GetBoolean();this.SetAlt(deserializer.GetObjectMin(D2L.LP.Text.IText));this.m_enabledInfo=deserializer.GetObjectMin(D2L.Images.Image);this.m_disabledInfo=deserializer.GetObjectMin(D2L.Images.Image);this.m_navInfo=deserializer.GetObjectMin(D2L.NavInfo)},Serialize:function(serializer){if(serializer!==null&&serializer!==undefined){serializer.AddMember("IE",
this.m_isEnabled);serializer.AddMember("A",this.m_alt);serializer.AddMember("EI",this.m_enabledInfo);serializer.AddMember("DI",this.m_disabledInfo);serializer.AddMember("NF",this.m_navInfo)}},BuildDom:function(){if(!this.m_hasDomBeenBuilt){arguments.callee.$.BuildDom.call(this);var item=this;this.SetDomNode(this.CreateElement("a"));this.m_img=this.CreateElement("img");this.m_img.className="dcs_a";if(this.IsEnabled())if(this.m_enabledInfo)this.m_enabledInfo.Assign(this.m_img);else this.m_img.src=this.m_enabledSrc;
else if(this.m_disabledInfo)this.m_disabledInfo.Assign(this.m_img);else this.m_img.src=this.m_disabledSrc;this.GetDomNode().appendChild(this.m_img);this.InstallEvents()}},IntegrateChild:function(parent,domNode){arguments.callee.$.IntegrateChild.call(this,parent,domNode);this.m_img=this.GetDomNode().firstChild;this.InstallEvents()},InstallEvents:function(){var me=this;var alt=this.m_alt;if(this.Parent()&&this.Parent().GetSubject)alt.SetSubject(this.Parent().GetSubject());if(this.GetDomNode().tagName.toLowerCase()==
"a")alt.AssignText(this.GetDomNode(),"title");if(this.m_img)alt.AssignText(this.m_img,"alt");this.SetNav(this.m_navInfo)},SetNav:function(navInfo){if(navInfo){this.m_navInfo=navInfo;var navStruct=this.m_navInfo.SetupHrefOnClick(this);if(this.IsEnabled())this.GetDomNode().href=navStruct.Href;if(navStruct.Target==null||navStruct.Target==""){if(this.GetDomNode().attributes.getNamedItem("target"))this.GetDomNode().attributes.removeNamedItem("target")}else this.GetDomNode().target=navStruct.Target;var me=
this;if(navStruct.OnClick)this.AttachObject(this.GetDomNode(),"onclick",function(){if(me.IsEnabled()&&navStruct.OnClick)return navStruct.OnClick.call(me)})}},GetAlt:function(){return this.m_alt},SetAlt:function(alt){this.m_alt=D2L.LP.Text.IText.Normalize(alt,"D2L.Control.CustomSelectorItemAction","SetAlt","alt");if(this.m_img){var me=this;this.m_alt.GetText().Register(function(val){if(val.length>0)me.m_img.alt=val})}},GetDisabledSrc:function(){if(this.m_disabledInfo)return this.m_disabledInfo.GetImageFile();
else return this.m_disabledSrc},GetDisabledInfo:function(){return this.m_disabledInfo},SetDisabledInfo:function(info){if(info){this.m_disabledInfo=info;if(this.m_img&&!this.IsEnabled())this.m_disabledInfo.Assign(this.m_img)}},GetEnabledSrc:function(){if(this.m_enabledInfo)return this.m_enabledInfo.GetImageFile();else return this.m_enabledSrc},GetEnabledInfo:function(){return this.m_enabledInfo},SetEnabledInfo:function(info){if(info){this.m_enabledInfo=info;if(this.m_img&&this.IsEnabled())this.m_enabledInfo.Assign(this.m_img)}},
GetOnClick:function(){UI.GetMessageArea().AddWarningMessage(new D2L.LP.Text.PlainText("CustomSelectorItemAction.SetOnClick() "+"is obsolete. Please use SetNav() instead."),true);if(this.m_navInfo&&this.m_navInfo.GetOnClick())return this.m_navInfo.GetOnClick();else return false},SetOnClick:function(onClick){if(onClick){if(this.m_navInfo==null)this.m_navInfo=new D2L.NavInfo;this.m_navInfo.SetOnClick(onClick);this.SetNav(this.m_navInfo)}},IsEnabled:function(){return this.m_isEnabled},SetIsEnabled:function(isEnabled){this.m_isEnabled=
isEnabled;if(this.m_img)if(isEnabled){if(this.m_enabledInfo)this.m_enabledInfo.Assign(this.m_img);else this.m_img.src=this.m_enabledSrc;this.GetDomNode().href=this.m_href}else{if(this.m_disabledInfo)this.m_disabledInfo.Assign(this.m_img);else this.m_img.src=this.m_disabledSrc;if(this.GetDomNode().attributes.getNamedItem("href"))this.GetDomNode().attributes.removeNamedItem("href")}}});
D2L.Control.OrgUnitSelector=D2L.Control.extend({Construct:function(){arguments.callee.$.Construct.call(this);this.showCurrentOuCheckbox=true;this.m_cs=null;this.m_currentOu=null;this.m_currentOuDiv=null;this.m_dialog=null;this.m_doEnableCheckbox=true;this.m_langTheOrgUnitTypeOrgUnitName="";this.m_langEveryDescendant="";this.OnAddItem=new D2L.EventHandler;this.OnDeleteItem=new D2L.EventHandler;this.OnRestoreItem=new D2L.EventHandler},IntegrateControlMin:function(deserializer){arguments.callee.$.IntegrateControlMin.call(this,
deserializer);var isEnabled=deserializer.GetBoolean();this.m_doEnableCheckbox=deserializer.GetBoolean();this.showCurrentOuCheckbox=deserializer.GetBoolean();this.m_langTheOrgUnitTypeOrgUnitName=deserializer.GetMember();this.m_langEveryDescendant=deserializer.GetMember();var allowMultiple=deserializer.GetBoolean();var options=deserializer.GetMember();var ouOptions=deserializer.GetMember();var dataSplit=deserializer.GetMember();var name=deserializer.GetMember();var allowOrg=deserializer.GetMember();
var descendantOptionsIncludeCurrent=deserializer.GetMember();if(name.length>0)this.m_cs=UI.GetByName(name+"_cs");else this.m_cs=UI.GetControl(this.GetMappedId()+"_cs");this.OnAddItem=this.m_cs.OnAddItem;this.OnDeleteItem=this.m_cs.OnDeleteItem;this.OnRestoreItem=this.m_cs.OnRestoreItem;if(this.showCurrentOuCheckbox){if(name.length>0)this.m_currentOu=UI.GetByName(name+"_currentOu");else this.m_currentOu=UI.GetControl(this.GetMappedId()+"_currentOu");this.m_currentOuDiv=UI.GetById(this.GetMappedId()+
"_currentOuDiv")}this.CreateDialog(allowMultiple,options,ouOptions,allowOrg,dataSplit,descendantOptionsIncludeCurrent);if(!isEnabled)this.Disable()},Add:function(orgUnitId,orgUnitName,orgUnitTypeName,ancestorOrgUnitId,ancestorOrgUnitName,ancestorOrgUnitTypeName,descendantOrgUnitTypeId,descendantOrgUnitTypeName){var key=orgUnitId+"_"+ancestorOrgUnitId+"_"+descendantOrgUnitTypeId;var contents="";if(orgUnitId>0)contents=this.m_langTheOrgUnitTypeOrgUnitName.replace("[0]",orgUnitTypeName).replace("[1]",
orgUnitName);else contents=this.m_langEveryDescendant.replace("[0]",descendantOrgUnitTypeName).replace("[1]",ancestorOrgUnitTypeName).replace("[2]",ancestorOrgUnitName);if(orgUnitId==Global.OrgUnitId&&this.showCurrentOuCheckbox){this.m_currentOu.checked=true;this.m_currentOuDiv.style.backgroundColor="#E6EFF2"}else{var existing=this.m_cs.GetItem(key);if(!existing){var newItem=new D2L.Control.CustomSelectorItem(key,contents);newItem.SetSubject(contents.stripHtml());this.m_cs.AppendChild(newItem)}}},
CreateDialog:function(allowMultiple,descendantOptions,orgUnitOptions,allowOrg,dataSplit,descendantOptionsIncludeCurrent){if(descendantOptionsIncludeCurrent===undefined)descendantOptionsIncludeCurrent=true;var dialogCallback=function(response){if(response.GetType()==D2L.Dialog.ResponseType.Positive){var orgUnits=response.GetData("OrgUnits");if(orgUnits)for(var i in orgUnits)me.Add(orgUnits[i].OrgUnitId,orgUnits[i].OrgUnitName,orgUnits[i].OrgUnitTypeName,orgUnits[i].AncestorOrgUnitId,orgUnits[i].AncestorOrgUnitName,
orgUnits[i].AncestorOrgUnitTypeName,orgUnits[i].DescendantOrgUnitTypeId,orgUnits[i].DescendantOrgUnitTypeName)}response.GetDialog().Close()};this.m_dialog=new D2L.Dialog.OrgUnitSelector(dialogCallback);this.m_dialog.SetAllowMultiple(allowMultiple);this.m_dialog.SetDescendantOptions(descendantOptions);this.m_dialog.SetDescendantOptionsIncludeCurrent(descendantOptionsIncludeCurrent);this.m_dialog.SetOrgUnitOptions(orgUnitOptions);this.m_dialog.SetAllowOrg(allowOrg);if(dataSplit)this.m_dialog.SetDataSplit(dataSplit);
var me=this;var onclick=function(){me.m_dialog.Open()};this.m_cs.SetAddOnClick(onclick)},Disable:function(){if(this.m_doEnableCheckbox&&this.showCurrentOuCheckbox)this.m_currentOu.disabled=true;this.m_cs.Disable()},Enable:function(){if(this.m_doEnableCheckbox&&this.showCurrentOuCheckbox)this.m_currentOu.disabled=false;this.m_cs.Enable()},Focus:function(){this.m_cs.Focus()},GetNumItems:function(){return this.m_cs.GetNumItems()},GetNumActiveItems:function(){return this.m_cs.GetNumActiveItems()},HasValue:function(){return new D2L.Util.DelayedReturn(this.HasValueNoDelay())},
HasValueNoDelay:function(){return this.m_cs.GetNumItems()>0},IsEnabled:function(){return this.m_cs.IsEnabled()},SetIsEnabled:function(isEnabled){if(isEnabled)this.Enable();else this.Disable()}});D2L.Control.OrgUnitSelector.OrgUnitOptions={DescendantsOnly:1,All:2,DescendantsOnlyExcludingCurrent:3};D2L.Control.OrgUnitSelector.DescendantOptions={None:0,All:1,UserChoice:2,CourseOfferings:3};
D2L.Control.Attachments=D2L.Control.CustomSelector.extend({Construct:function(){arguments.callee.$.Construct.call(this,"",true);this.m_name="";this.type=0},IntegrateControlMin:function(deserializer){arguments.callee.$.IntegrateControlMin.call(this,deserializer);var items=deserializer.GetObjectArrayMin(D2L.Control.Attachment);for(var i=0;i<items.length;i++)this.AppendChild(items[i])},AddAttachment:function(attachment){this.AddItem(attachment)}});
D2L.Control.Attachment=D2L.Control.CustomSelectorItem.extend({Construct:function(fileId,text,canDelete){arguments.callee.$.Construct.call(this,fileId,text);this.SetIsNew(false)},DeserializeMin:function(deserializer){this.m_key=deserializer.GetMember();this.SetCanDelete(deserializer.GetBoolean());this.SetContent(deserializer.GetMember())},BuildDom:function(){if(this.Parent().type==1){this.SetDomNode(document.createElement("span"));this.IChildrenDomNode=this.GetDomNode();if(this.Parent().type==1&&this.Parent().Children().length>
0)this.m_contents=";&nbsp;"+this.m_contents;this.GetDomNode().innerHTML=this.m_contents}else arguments.callee.$.BuildDom.call(this)}});D2L.Attachments=D2L.Control.Attachments;D2L.Attachment=D2L.Control.Attachment;D2L.CustomSelector=D2L.Control.CustomSelector;D2L.CustomSelectorItem=D2L.Control.CustomSelectorItem;D2L.CustomSelectorItemAction=D2L.Control.CustomSelectorItemAction;D2L.OrgUnitSelector=D2L.Control.OrgUnitSelector;if(window["D2L"]!==undefined&&D2L.LP.Web.Packaging!==undefined)D2L.LP.Web.Packaging.Register("D2L.LP.Web.Controls.Selectors.default");