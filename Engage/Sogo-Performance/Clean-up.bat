title Sogo-Performance Clean Up

DEL /Q %CD%\reportlog\*

DEL /Q %CD%\screenshots\failure\*
DEL /Q %CD%\surefire-reports\*
FOR /D %%p IN (%CD%\surefire-reports\*) DO RMDIR "%%p" /S /Q

DEL /Q "%CD%\Extent Reports\"*.html
DEL /Q "%CD%\Extent Reports\Screenshots\"*

IF EXIST %CD%\PlatformReadings\ DEL /Q "%CD%\PlatformReadings\"*

IF EXIST %CD%\recordings\ (
	DEL /Q "%CD%\recordings\"*
	FOR /D %%p IN ("%CD%\recordings\"*) DO RMDIR "%%p" /S /Q
)

