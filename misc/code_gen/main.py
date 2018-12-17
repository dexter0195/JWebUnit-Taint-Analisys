#!/usr/bin/env python
from codegen import CodeGen
import sys


codegen = CodeGen()
codegen.doAllTheStuff(sys.argv[1])
print("Bye")
