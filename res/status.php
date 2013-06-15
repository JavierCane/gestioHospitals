<?php

namespace SistemaSalut;

class StatusCtrl
{
	public function returnStatus()
	{
		echo "OK";
	}
}

$home = new StatusCtrl();

$home->returnStatus();

