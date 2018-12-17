import re
import os
from pprint import pprint


class CodeGen:

    def __init__(self):
        pass

    def findFormName(self, nodeData):

        path = os.path.join("/home/alessio/schoolmate-dir", nodeData["file"])
        lines = []
        forms = []
        with open(path, "r") as rootSource:
            lines = rootSource.readlines()
        for i in lines:
            if "<form name" in i:
                form = re.sub(r'.*name=\'([\S]+)\'.*',r'\1',i).strip()
                if form != "":
                    forms.append(form)

        if len(forms) > 1:
            print("multiple forms found")
            print(forms)
            return []
        elif len(forms) == 0:
            print("no forms found")
            return []
        else:
            # print("the form is")
            # print(forms[0])
            return forms[0]


    def evaluatetree(self, file):

        lines = []
        root = {}
        leafs = []
        formName = ""

        with open(file,"r") as dotFile:
            lines = dotFile.readlines()

        for i in lines:
            if "doubleoctagon" in i:
                root = {
                    "file": re.sub(r'.*label=\"([a-zA-Z]*\.php).*',r'\1',i).strip(),
                    "row" : int(re.sub(r'.*:\ ([0-9]+).*',r'\1', i).strip())
                }
            if "filled" in i:
                if "ellipse" not in i:
                    file = re.sub(r'.*label=\"([a-zA-Z]*\.php).*',r'\1',i).strip()
                    row = int(re.sub(r'.*:\ ([0-9]+).*',r'\1', i).strip())
                    var = re.sub(r'.*POST\[(\S*)\].*',r'\1', i).strip()
                    leafs.append({
                        "file" : file,
                        "row" : row,
                        "var" : var
                    })

        # print(root)
        # pprint(leafs)

        formName = self.findFormName(root)
        print("formname :", formName)
        for i in leafs:
            print("Variable to taint :", i["var"])

    def getFiles(self, dir):

        dotfiles = []

        # traverse root directory, and list directories as dirs and files as files
        for root, dirs, files in os.walk(dir):
            path = root.split(os.sep)
            for file in files:
                if "dot" in file:
                    f = os.path.join(root,file)
                    dotfiles.append(f)

        return dotfiles

    def doAllTheStuff(self, dir):

        for i in self.getFiles(dir):
            print(i)
            self.evaluatetree(i)

        # print(dotfiles)

