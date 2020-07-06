create definer = root@`%` event updateInvitationCode_last
  on schedule
    every '1' DAY
      starts '2020-06-27 01:00:00'
  enable
do
  BEGIN

    update invitationCodeList
    set last = 3;

  END;

