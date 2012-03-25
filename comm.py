# Script to automate git commits. very helpful.
def raw_default(prompt, dflt=None):
	prompt = "%s [%s]: " % (prompt, dflt)
	res = raw_input(prompt)
	if not res and dflt:
		return dflt
	return res

import os
c = '"'+raw_default("Commit message", "comm")+'"'
r = raw_default("Remote", "origin")
b = raw_default("Branch", "master")
os.system('git add .')
os.system('git commit -m '+c)
os.system('git push '+r+' '+b)
