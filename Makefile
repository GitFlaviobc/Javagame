# ****************************************************************************************** #
#                                                                                            #
#                                                         :::::::::: :::::::::   :::::::     #
#  Makefile                                              :+:        :+:    :+: :+:    :+     #
#                                                       +:+        +:+    +:+ +:+            #
#  By: Flavio BC <github.com/GitFlaviobc>             :#::+::#   +#++:++#+  +#+              #
#                                                    +#+        +#+    +#+ +#+               #
#  Created: 2022/08/28 14:31:13 by Flavio BC        #+#        #+#    #+# #+#    #+#         #
#  Updated: 2022/09/01 12:34:03 by Flavio BC       ###        #########   ########           #
#  License: MIT                                                                              #
#                                                                                            #
# ****************************************************************************************** #

NAME			=	Game

JV				=	java
JVC				=	javac
JAVADC			=	javadoc
JAR				=	jar
CLASS			=	class

APP				=	$(NAME).$(JAR)

PKG				=	view
SUBPKG			=	-subpackages model

APP_DIR			=	Game/
SRC_DIR			=	src/
VIEW_DIR		=	view/
MODEL_DIR		=	model/
BIN_DIR			=	bin/
DOC_DIR			=	../doc/

RM				=	rm -rf
JAVACFLAGS		=	-g -d $(APP_DIR)$(BIN_DIR)
JARFLAGS		=	cvfe
DOCFLAGS		=	-d
GOBIN			=	cd $(APP_DIR)$(BIN_DIR) &&
GOSRC			=	cd $(APP_DIR)$(SRC_DIR) &&
MV				=	mv

SRC				=	$(MODEL_DIR)Calculation.$(JV) \
					$(VIEW_DIR)Game.$(JV)

CLASS_FILES		=	$(SRC:.$(JV)=.$(CLASS))

SRC_FILES		=	$(addprefix $(APP_DIR)$(SRC_DIR), $(SRC))
BIN_FILES		=	$(addprefix $(APP_DIR)$(BIN_DIR), $(CLASS_FILES))


all: $(APP)

$(APP): $(BIN_FILES)
	$(GOBIN) $(JAR) $(JARFLAGS) $(NAME).$(JAR) $(VIEW_DIR)$(NAME) *
	$(MV) $(APP_DIR)$(BIN_DIR)$(APP) $(APP)

$(BIN_FILES):
	@mkdir -p $(APP_DIR)$(BIN_DIR)
	$(JVC) $(JAVACFLAGS) $(SRC_FILES)

doc: all
	$(GOSRC) $(JAVADC) $(DOCFLAGS) $(DOC_DIR) $(PKG) $(SUBPKG)

run: all
	$(JV) -$(JAR) $(APP)

clean:
	$(RM) $(APP_DIR)$(BIN_DIR)

fclean:	clean
	$(RM) $(APP)
	$(RM) $(APP_DIR)$(DOC_DIR)

re:		fclean all

.PHONY:		all clean fclean re run doc
