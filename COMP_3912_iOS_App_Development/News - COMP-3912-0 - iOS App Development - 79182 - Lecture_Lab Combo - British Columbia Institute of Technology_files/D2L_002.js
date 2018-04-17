
D2L.Control.FileSelector=D2L.Control.CustomSelector.extend({Construct:function(){arguments.callee.$.Construct.call(this);this.m_areaFilters=["MyComputer","OuFiles"];this.m_canDelete=true;this.m_customDialogs=new D2L.Util.Dictionary;this.m_selectedArea="";this.m_selectedAreaParam="";this.m_fileFilters=[D2L.Files.FilterType.All];this.m_maxFileSize=0;this.m_submitFileDialog=null;this.m_totalFileSize=0;this.m_raiseAddRemoveEvent=true;this.m_forceSaveToCourseFiles=false;this.OnAddRemove=new D2L.EventHandler},
AppendChild:function(file){file=arguments.callee.$.AppendChild.call(this,file);if(file)this.UpdateFileSizes();if(file&&this.m_raiseAddRemoveEvent)this.OnAddRemove.Trigger(file);return file},IntegrateControlMin:function(deserializer){arguments.callee.$.IntegrateControlMin.call(this,deserializer);this.m_maxFileSize=deserializer.GetMember();this.m_canDelete=deserializer.GetBoolean();this.m_fileFilters=deserializer.GetMember();this.m_areaFilters=deserializer.GetMember();this.m_selectedArea=deserializer.GetMember();
this.m_selectedAreaParam=deserializer.GetMember();this.m_forceSaveToCourseFiles=deserializer.GetBoolean();var files=deserializer.GetObjectArrayMin(D2L.Control.FileSelector.File);this.m_integrationComplete=false;for(var i=0;i<files.length;i++)this.AppendChild(files[i]);this.m_integrationComplete=true},RemoveChild:function(file,doRemove){file=arguments.callee.$.RemoveChild.call(this,file,doRemove);if(file)this.UpdateFileSizes();if(file&&this.m_raiseAddRemoveEvent)this.OnAddRemove.Trigger(file);return file},
AddAreaFilter:function(area){area=area.toLowerCase();var found=false;for(var i=0;i<this.m_areaFilters.length;i++)if(this.m_areaFilters[i]==area){found=true;break}if(!found)this.m_areaFilters.push(area)},Clear:function(){while(this.Children().length>0)this.RemoveChild(this.Children()[0],true)},GetTotalFileSize:function(){var total=0;for(var i=0;i<this.Children().length;i++)if(!this.Children()[i].IsDeleted())total+=this.Children()[i].GetFile().GetSize();return total},GetCount:function(){var count=0;
for(var i=0;i<this.Children().length;i++)if(!this.Children()[i].IsDeleted())count+=1;return count},HasValue:function(){return new D2L.Util.DelayedReturn(this.HasValueNoDelay())},HasValueNoDelay:function(){var numChildren=0;for(var i=0;i<this.Children().length;i++)if(!this.Children()[i].IsDeleted())numChildren++;return numChildren>0},OpenDialog:function(){if(!this.m_submitFileDialog){var me=this;var callback=function(dialogResponse){var files=dialogResponse.GetData("files");var sources=dialogResponse.GetData("sources");
if(files)for(var i=0;i<files.length;i++){var file=D2L.Serialization.JsonDeserializer.Deserialize(D2L.Serialization.JsonSerializer.Serialize(files[i]),D2L.Files.FileInfo);var item=new D2L.Control.FileSelector.File(file,sources[file.FileId]);item.SetIsNew(true);me.AppendChild(item)}dialogResponse.GetDialog().Close()};this.m_submitFileDialog=new D2L.Dialog.SelectFile(callback)}this.m_submitFileDialog.SetForceSaveToCourseFiles(this.m_forceSaveToCourseFiles);this.m_submitFileDialog.SetFileFilters(this.m_fileFilters);
this.m_submitFileDialog.SetAreaFilters(this.m_areaFilters);this.m_submitFileDialog.SetSelectedArea(this.m_selectedArea,this.m_selectedAreaParam);this.m_submitFileDialog.SetAllowMultiple(this.m_allowMultiple);this.m_submitFileDialog.SetMaxFileSize(this.m_maxFileSize);this.m_submitFileDialog.Open(this)},OpenCustomDialog:function(dialogClassName,dialogSrc,sourceName){var dialog=this.m_customDialogs.Get(dialogClassName);if(dialog===undefined){var me=this;var callback=function(dialogResponse){var file=
dialogResponse.GetData("file");var source=new D2L.LP.Text.PlainText(sourceName);if(file){file=D2L.Serialization.JsonDeserializer.Deserialize(D2L.Serialization.JsonSerializer.Serialize(file),D2L.Files.FileInfo);var item=new D2L.Control.FileSelector.File(file,source);item.SetIsNew(true);me.AppendChild(item)}dialogResponse.GetDialog().Close()};var dialogClass=eval(dialogClassName);dialog=new dialogClass(dialogSrc,callback);this.m_customDialogs.Add(dialogClassName,dialog)}dialog.Open(this)},RemoveAreaFilter:function(area){area=
area.toLowerCase();for(var i=0;i<this.m_areaFilters.length;i++)if(this.m_areaFilters[i]==area){this.m_areaFilters.splice(i,1);break}if(area==this.m_selectedArea)this.m_selectedArea=""},RestoreItem:function(file){arguments.callee.$.RestoreItem.call(this,file);this.UpdateFileSizes();if(file&&this.m_raiseAddRemoveEvent)this.OnAddRemove.Trigger(file)},SetFile:function(file){file=D2L.Serialization.JsonDeserializer.Deserialize(file,D2L.Files.FileInfo);var existing=this.GetItem(file.FileId);if(existing){existing.SetSubject(file.GetFileName());
existing.m_file=file;existing.m_domHasBeenBuilt=false;existing.BuildDom();this.UpdateFileSizes()}else{var fsFile=new D2L.Control.FileSelector.File(file);fsFile.SetCanDelete(this.m_canDelete);fsFile.SetIsNew(false);this.AppendChild(fsFile)}},SetFiles:function(files){this.m_raiseAddRemoveEvent=false;for(var i=0;i<files.length;i++)this.SetFile(files[i]);this.m_raiseAddRemoveEvent=true},SetSelectedArea:function(selectedArea,param){selectedArea=selectedArea.toLowerCase();this.m_selectedArea=selectedArea;
if(param!==undefined)this.m_selectedAreaParam=param;this.AddAreaFilter(selectedArea)},UpdateFileSizes:function(){this.m_totalFileSize=0;for(var i=0;i<this.Children().length;i++)if(!this.Children()[i].IsDeleted())this.m_totalFileSize+=this.Children()[i].GetFile().Size}});D2L.FileSelector=D2L.Control.FileSelector;D2L.FileSelector.FILE_TYPES=new Array("Url","CourseFile","UploadedFile");
D2L.Control.FileSelector.File=D2L.Control.CustomSelectorItem.extend({Construct:function(file,source){var key="";if(file!==undefined)key=file.FileId;arguments.callee.$.Construct.call(this,key);this.m_file=file;this.m_fileLink=null;this.m_navigation="";this.m_source=null;this.m_deleteCellVAlign="top";if(file!==undefined){this.SetData("FileSystemType",file.GetFileSystemType());this.SetData("FileId",file.GetFileId());this.SetData("NewFileName","");this.SetSubject(file.GetFileName())}if(source!==undefined)this.m_source=
source},DeserializeMin:function(deserializer){var fileSystemType=deserializer.GetMember();var fileId=deserializer.GetMember();this.m_key=fileId;this.m_file=new D2L.Files.FileInfo(fileSystemType,fileId);this.m_canDelete=deserializer.GetBoolean();this.m_isDeleted=deserializer.GetBoolean();this.m_isNew=deserializer.GetBoolean();this.m_navigation=deserializer.GetMember();this.SetData("FileSystemType",this.m_file.GetFileSystemType());this.SetData("FileId",this.m_file.GetFileId());this.SetData("NewFileName",
"");this.SetSubject(this.m_file.GetFileName())},BuildDom:function(){arguments.callee.$.BuildDom.call(this);var container=this.CreateElement("div");if(!this.m_fileLink)this.m_fileLink=new D2L.Control.FileLink(this.m_file,this.m_source);else this.m_fileLink.SetFile(this.m_file,false);if(this.m_navigation.length>0)this.m_fileLink.SetNavigation(this.m_navigation);this.AppendChild(this.m_fileLink)},GetFile:function(){return this.m_file},Focus:function(){if(this.m_fileLink)this.m_fileLink.Focus()},RenameFile:function(newFileName){this.SetData("NewFileName",
newFileName);this.SetSubject(newFileName);this.m_file.Rename(newFileName);if(this.m_fileLink)this.m_fileLink.SetFile(this.m_file,false)}});D2L.FileSelector.File=D2L.Control.FileSelector.File;if(window["D2L"]!==undefined&&D2L.LP.Web.Packaging!==undefined)D2L.LP.Web.Packaging.Register("D2L.LP.Web.Controls.FileSelector.default");